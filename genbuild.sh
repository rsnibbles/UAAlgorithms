#!/bin/bash

main_dir="main/"
test_dir="test/"
tdir="target/"
jc='javac includeantruntime="false"'

function get_target_name() {
	if [[ -n $(echo $2 | grep '.java') ]]; then
		echo $2 | tr '/' '\n' | tail -1 | cut -d'.' -f1
	else
		# TODO: oh god why
		if [[ $1 == $test_dir ]]; then
			echo -n "Test"
		fi
		echo $2 | sed "s|^$1||"
	fi
}

function non_test_version() {
	if [[ -n $(echo $1 | grep '.java') ]]; then
		echo $(dirname "$1")/$(basename "$1" | sed 's/Test//')
	else
		echo "$1"
	fi
}

# gen_tlt "compile" "$main_dir" >> build.xml
function gen_tlt() {
	echo ""
	echo -e "\t<target name=\"$1\">"

	find "$2" -type f -name '*.java' | while read path; do
		get_target_name "$2" "$(echo "$path" | sed "s|^$2||" | cut -d'/' -f1)"
	done | sort -u | sed -e 's/^/\t\t<antcall target="/' -e 's|$|" />|'

	echo -e "\t</target>"

	find "$2" -type f -name '*.java' | while read path; do
		echo "$path" | sed "s|^$2||" | cut -d'/' -f1
	done | sort -u | while read target; do
		gen_target "$target" "$2"
	done
}

function gen_target() { # {{{
	if [[ -n $(echo "$2$1" | grep '.java$') ]]; then
		fn="$(echo $1 | tr '/' '\n' | tail -1)"
		tn="$(echo $fn | cut -d'.' -f1)"
		sdir="$(echo "$2$1" | sed -r 's|/[^/]+$|/|')"

		echo ""
		# print algorithm target alias
		echo -e "\t<target name=\"$tn\""
		echo -e "\t\tdepends=\"$1\" />"

		echo -ne "\t<target name=\"$1\""

		deps="$(sed -nre 's/^import (main|test)\.(.+);.*/\2/p' "$2$1" | sort -u | \
			tr '.' '/' | sed 's/$/.java/' | tr '\n' ',' | sed 's/,$//' )"
		if [[ -n $deps ]]; then
			echo -ne " depends=\"$deps\""
		fi

		echo -e " >"
		echo -e "\t\t<mkdir dir=\"$tdir\" />"
		echo -e "\t\t<$jc srcdir=\"$sdir\" destdir=\"$tdir\" includes=\"$fn\" />"
		echo -e "\t</target>"
		return
	fi

	echo ""
	# TODO: oh god why
	if [[ $2 == $test_dir ]]; then
		echo -e "\t<target name=\"Test$1\" "
	else
		echo -e "\t<target name=\"$1\" "
	fi

	find "$2$1" -mindepth 1 -maxdepth 1 | while read ltname; do
		get_target_name "$2" "$ltname"
	done | sort -u | tr '\n' ',' | sed -e 's/^/\t\tdepends="/' -e 's/,$//'

	# TODO: oh god why
	if [[ $2 == $test_dir ]]; then
		echo -n ",$(non_test_version $1)"
	fi

	echo -e "\" />"

	if [[ -z $(echo $1 | grep '.java$') ]]; then
		find "$2$1" -type f -name '*.java' | while read path; do
			echo "$1/$(echo "$path" | sed "s|^$2$1||" | cut -d'/' -f2)"
		done | sort -u | while read target; do
			gen_target "$target" "$2"
		done
	fi
} # }}}

gcid="$(git rev-list --all --max-count=1)"
echo "<!-- generated: $(date) by genbuild.sh @$gcid -->" > build.xml

cat >> build.xml << ENDHEADER
<project name="UAAlgorithms" default="all" >
	<target name="clean">
		<delete dir="target" verbose="true" includeemptydirs="true" />
	</target>

	<target name="all">
		<antcall target="compile" />
		<antcall target="tests" />
	</target>
ENDHEADER

gen_tlt "compile" "$main_dir" >> build.xml
gen_tlt "tests" "$test_dir" >> build.xml

cat >> build.xml << ENDFOOTER
</project>
ENDFOOTER

