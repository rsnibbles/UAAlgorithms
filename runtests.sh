#!/bin/bash

total_failed=0
while read tname; do
	tname="$(basename "$tname" | cut -d'.' -f1)"
	./run.sh "$tname"
	total_failed=$((total_failed + $?))
done < <(find target/test -type f -name '*.class')

if [[ $total_failed != 0 ]]; then
	echo -n "FAILED: $total_failed test"
	[[ $total_failed > 1 ]] && echo -n "s"
	echo ""
fi

exit $total_failed

