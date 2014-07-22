#!/bin/sh

if ! which ndk-build >/dev/null 2>&1; then
	echo "ndk-build not found in PATH"
	exit 1
fi

SCRIPTDIR=`dirname $0`
MUPDF=mupdf-a3d00b2c51c1df23258f774f58268be794384c27
FREETYPE=freetype-2.4.10
OPENJPEG=openjpeg-1.5.1
JBIG2DEC=jbig2dec-0.11
JPEGSRC=jpegsrc.v8d.tar.gz
JPEGDIR=jpeg-8d

cd "$SCRIPTDIR/../deps"

echo "extracting deps"
tar xvf $FREETYPE.tar.bz2
tar xvf $JPEGSRC
tar xvf $MUPDF.tar.bz2
tar xvf $OPENJPEG.tar.gz
tar xvf $JBIG2DEC.tar.gz

echo "copying openjpeg"
cp $OPENJPEG/libopenjpeg/*.[ch] ../jni/openjpeg/
echo "configuring openjpeg"
echo '#define PACKAGE_VERSION' '"'$OPENJPEG'"' > ../jni/openjpeg/opj_config.h

echo "copying jpeg"
cp $JPEGDIR/*.[ch] ../jni/jpeg/

echo "copying jbig2dec"
cp $JBIG2DEC/* ../jni/jbig2dec/

echo "copying mupdf"
for x in draw fitz pdf ; do
    cp -r $MUPDF/$x/*.[ch] ../jni/mupdf/$x/
done

echo "patching mupdf"
cd ..
patch jni/mupdf/fitz/fitz.h jni/mupdf-apv/fitz/apv_fitz.h.patch
patch -o jni/mupdf-apv/fitz/apv_doc_document.c jni/mupdf/fitz/doc_document.c jni/mupdf-apv/fitz/apv_doc_document.c.patch
patch -o jni/mupdf-apv/pdf/apv_pdf_cmap_table.c jni/mupdf/pdf/pdf_cmap_table.c jni/mupdf-apv/pdf/apv_pdf_cmap_table.c.patch
patch -o jni/mupdf-apv/pdf/apv_pdf_fontfile.c jni/mupdf/pdf/pdf_fontfile.c jni/mupdf-apv/pdf/apv_pdf_fontfile.c.patch
cd -


echo "copying freetype"
cp -r $FREETYPE/{src,include} ../jni/freetype/

cd ..

echo "running ndk-build"
ndk-build

echo "build-native done"
