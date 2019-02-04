#!/bin/sh

EXPERIMENT="$1"
DATE=$(date +%Y-%m-%d)

clj -A:"$EXPERIMENT"
cp outputs/"$EXPERIMENT".csv data/"$EXPERIMENT"-"$DATE".csv
