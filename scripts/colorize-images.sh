#!/bin/sh

SCRIPTDIR=`dirname $0`
cd $SCRIPTDIR/..
RED="0.5 0.5 0.5 0 0 0 0 0 0"
GREEN="0 0 0 0.5 0.5 0.5 0 0 0"

for x in btn_zoom_down_disabled.9 btn_zoom_down_disabled_focused.9 btn_zoom_down_normal.9 btn_zoom_up_disabled.9 btn_zoom_up_disabled_focused.9 btn_zoom_up_normal.9 btn_zoom_width_normal ; do
  convert res/drawable/$x.png -recolor "$RED" res/drawable/red_$x.png
  convert res/drawable/$x.png -recolor "$GREEN" res/drawable/green_$x.png
  convert res/drawable-hdpi/$x.png -recolor "$RED" res/drawable-hdpi/red_$x.png
  convert res/drawable-hdpi/$x.png -recolor "$GREEN" res/drawable-hdpi/green_$x.png
done


