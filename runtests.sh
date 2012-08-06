#!/bin/bash

find target/test -type f -name '*.class' | while read tname; do
	tname="$(basename "$tname" | cut -d'.' -f1)"
	./run.sh "$tname"
done

