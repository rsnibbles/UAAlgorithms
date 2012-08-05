#!/bin/bash

mdir="src/main/"
jc='javac includeantruntime="false"'

function get_target_name() {
	if [[ -n $(echo $1 | grep '.java') ]]; then
		echo $1 | tr '/' '\n' | tail -1 | cut -d'.' -f1
	else
		echo $1 | sed "s|^$mdir||"
	fi
}

function gen_compile() {
	echo -e "\t<target name=\"compile\">"

	find "$mdir" -type f -name '*.java' | while read path; do
		echo "$path" | sed "s|^$mdir||" | cut -d'/' -f1
	done | sort -u | sed -e 's/^/\t\t<antcall target="/' -e 's|$|" />|'

	echo -e "\t</target>"

	find "$mdir" -type f -name '*.java' | while read path; do
		echo "$path" | sed "s|^$mdir||" | cut -d'/' -f1
	done | sort -u | while read target; do
		gen_build_target "$target"
	done
}

function gen_build_target() {
	if [[ -n $(echo "$mdir$1" | grep '.java$') ]]; then
		fn="$(echo $1 | tr '/' '\n' | tail -1)"
		tn="$(echo $fn | cut -d'.' -f1)"
		sdir="$(echo "$mdir$1" | sed -r 's|/[^/]+$|/|')"
		tdir="$(echo "$sdir" | sed 's|src|target|' )"
		echo ""
		echo -e "\t<target name=\"$tn\""
		echo -e "\t\tdepends=\"$1\" />"
		echo -e "\t<target name=\"$1\">"
		echo -e "\t\t<mkdir dir=\"$tdir\" />"
		echo -e "\t\t<$jc srcdir=\"$sdir\" destdir=\"$tdir\" includes=\"$fn\" />"
		echo -e "\t</target>"
		return
	fi

	echo ""
	echo -e "\t<target name=\"$1\" "

	find "$mdir$1" -mindepth 1 -maxdepth 1 | while read ltname; do
		get_target_name "$ltname"
	done | sort -u | tr '\n' ',' | sed -e 's/^/\t\tdepends="/' -e 's/,$/"/'

	echo -e " />"

	if [[ -z $(echo $1 | grep '.java$') ]]; then
		find "$mdir$1" -type f -name '*.java' | while read path; do
			echo "$1/$(echo "$path" | sed "s|^$mdir$1||" | cut -d'/' -f2)"
		done | sort -u | while read target; do
			gen_build_target "$target"
		done
	fi
}

gcid="$(git rev-list --all --max-count=1)"
echo "<!-- generated: $(date) by genbuild.sh @$gcid -->" > build.xml

cat >> build.xml << ENDHEADER
<project name="UAAlgorithms" default="compile" >
	<target name="clean">
		<delete dir="target" verbose="true" includeemptydirs="true" />
	</target>

	<target name="all">
		<antcall target="compile" />
		<antcall target="test" />
	</target>

ENDHEADER

gen_compile >> build.xml



cat >> build.xml << ENDFOOTER
</project>
ENDFOOTER

