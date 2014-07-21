#!/bin/sh

SCRIPTDIR=`dirname $0`
cd $SCRIPTDIR/..

for x in upfolder folder home recent1 recent2 recent3 recent4 recent5 ; do
  convert res/drawable-hdpi/$x.png -resize 66.7% res/drawable-mdpi/$x.png
  convert res/drawable-hdpi/$x.png -resize 50% res/drawable-ldpi/$x.png
done
