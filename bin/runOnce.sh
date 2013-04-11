#!/bin/sh
FILES=../textfiles/*
mkdir gzip_files
cd gzip_files
for i in $FILES
do
    gzip -c $i > "$i.gz"
    mv "$i.gz" .
done 
