#!/bin/bash

if [[ -z $1 ]]; then
	echo "Usage: $0 <class name>"
	exit 0
fi

target="$(find target/ -iname "$1.class")"
if [[ -z $target ]]; then
	echo "error: unable to find that class"
	echo "       make sure you've compiled it"
	exit 1
fi

cpath="$(echo $target | sed -e 's|target/||' -e 's/.class$//' -e 's|/|.|g')"
java -classpath target/ $cpath

