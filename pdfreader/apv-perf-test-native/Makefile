

JNI_DIR=../jni

CFLAGS=-Wall -O0 -ggdb \
	-DFT2_BUILD_LIBRARY \
	-DNOCJK \
	-I$(JNI_DIR)/pdfview2 \
	-I$(JNI_DIR)/mupdf/fitz \
	-I$(JNI_DIR)/mupdf/pdf \
	-I$(JNI_DIR)/jbig2dec \
	-I$(JNI_DIR)/freetype-overlay/include \
	-I$(JNI_DIR)/freetype/include \
	-I$(JNI_DIR)/openjpeg

LDFLAGS=-O0 -ggdb -L.

FITZ_OBJS=base_context.o \
	base_error.o \
	base_hash.o \
	base_memory.o \
	base_string.o \
	base_geometry.o \
	\
	crypt_aes.o \
	crypt_arc4.o \
	crypt_md5.o \
	crypt_sha2.o \
	\
	stm_buffer.o \
	stm_open.o \
	stm_read.o \
	\
	filt_basic.o \
	filt_dctd.o \
	filt_faxd.o \
	filt_flate.o \
	filt_lzwd.o \
	filt_predict.o \
	filt_jbig2d.o \
	\
	res_colorspace.o \
	res_font.o \
	res_pixmap.o \
	res_shade.o \
	res_text.o \
	res_path.o \
	res_bitmap.o \
	res_store.o \
	\
	image_jpx.o \
	\
	dev_list.o \
	dev_text.o \
	dev_bbox.o \
	dev_null.o \
	\
	apv_doc_document.o \
	doc_link.o


FITZ_DRAW_OBJS=draw_device.o \
        draw_blend.o \
        draw_glyph.o \
        draw_affine.o \
        draw_scale.o \
        draw_unpack.o \
        draw_mesh.o \
	draw_path.o \
        draw_paint.o \
	draw_edge.o


PDF_OBJS=apv_pdf_debug.o \
	pdf_lex.o \
	pdf_nametree.o \
	pdf_parse.o \
	pdf_repair.o \
	pdf_stream.o \
	pdf_xref.o \
	pdf_xref_aux.o \
	pdf_annot.o \
	pdf_outline.o \
	pdf_cmap.o \
	pdf_cmap_parse.o \
	pdf_cmap_load.o \
	pdf_cmap_table.o \
	pdf_encoding.o \
	pdf_unicode.o \
	pdf_font.o \
	pdf_type3.o \
	pdf_metrics.o \
	pdf_fontfile.o \
	pdf_function.o \
	pdf_colorspace.o \
	pdf_image.o \
	pdf_pattern.o \
	pdf_shade.o \
	pdf_object.o \
	pdf_xobject.o \
	pdf_interpret.o \
	pdf_page.o \
	pdf_store.o \
	pdf_crypt.o



FREETYPE_OBJS=ftsystem.o \
	ftinit.o \
	ftdebug.o \
	ftbase.o \
	ftbbox.o \
	ftglyph.o \
	ftbitmap.o \
	ftcid.o \
	ftfstype.o \
	ftgasp.o \
	ftgxval.o \
	ftlcdfil.o \
	ftmm.o \
	ftotval.o \
	ftpatent.o \
	ftstroke.o \
	ftsynth.o \
	fttype1.o \
	ftxf86.o \
	cff.o \
	type1cid.o \
	sfnt.o \
	truetype.o \
	type1.o \
	raster.o \
	smooth.o \
	autofit.o \
	ftcache.o \
	gxvalid.o \
	otvalid.o \
	psaux.o \
	pshinter.o \
	psnames.o


JBIG2DEC_OBJS=jbig2.o \
	jbig2_arith.o \
	jbig2_arith_iaid.o \
	jbig2_arith_int.o \
	jbig2_generic.o \
	jbig2_halftone.o \
	jbig2_huffman.o \
	jbig2_image.o \
	jbig2_image_pbm.o \
	jbig2_metadata.o \
	jbig2_mmr.o \
	jbig2_page.o \
	jbig2_refinement.o \
	jbig2_segment.o \
	jbig2_symbol_dict.o \
	jbig2_text.o \
	jbig2dec.o \
	sha1.o


JPEG_OBJS=jaricom.o \
	jcapimin.o \
	jcapistd.o \
	jcarith.o \
	jccoefct.o \
	jccolor.o \
	jcdctmgr.o \
	jchuff.o \
	jcinit.o \
	jcmainct.o \
	jcmarker.o \
	jcmaster.o \
	jcomapi.o \
	jcparam.o \
	jcprepct.o \
	jcsample.o \
	jctrans.o \
	jdapimin.o \
	jdapistd.o \
	jdarith.o \
	jdatadst.o \
	jdatasrc.o \
	jdcoefct.o \
	jdcolor.o \
	jddctmgr.o \
	jdhuff.o \
	jdinput.o \
	jdmainct.o \
	jdmarker.o \
	jdmaster.o \
	jdmerge.o \
	jdpostct.o \
	jdsample.o \
	jdtrans.o \
	jerror.o \
	jfdctflt.o \
	jfdctfst.o \
	jfdctint.o \
	jidctflt.o \
	jidctfst.o \
	jidctint.o \
	jquant1.o \
	jquant2.o \
	jutils.o \
	jmemmgr.o \
	jmemnobs.o


OPENJPEG_LIBS=bio.o \
	cio.o \
	dwt.o \
	event.o \
	image.o \
	j2k.o \
	j2k_lib.o \
	jp2.o \
	jpt.o \
	mct.o \
	mqc.o \
	openjpeg.o \
	pi.o \
	raw.o \
	t1.o \
	t1_generate_luts.o \
	t2.o \
	tcd.o \
	tgt.o \
	cidx_manager.o \
	tpix_manager.o \
	ppix_manager.o \
	thix_manager.o \
	phix_manager.o




default: aptn


aptn: aptn.o apv.o libfitz.a libfreetype.a libfitzdraw.a libpdf.a libjbig2dec.a libjpeg.a libopenjpeg.a
	gcc $(LDFLAGS) -o aptn aptn.o apv.o -lfitz -lfreetype -lz -lfitzdraw -lpdf -ljbig2dec -ljpeg -lopenjpeg


aptn.o: aptn.c
	gcc $(CFLAGS) -c -o aptn.o aptn.c




# FITZ

libfitz.a: $(FITZ_OBJS)
	ar rcs libfitz.a $(FITZ_OBJS)

base_context.o: $(JNI_DIR)/mupdf/fitz/base_context.c
	gcc $(CFLAGS) -c -o base_context.o $(JNI_DIR)/mupdf/fitz/base_context.c

base_error.o: $(JNI_DIR)/mupdf/fitz/base_error.c
	gcc $(CFLAGS) -c -o base_error.o $(JNI_DIR)/mupdf/fitz/base_error.c

base_hash.o: $(JNI_DIR)/mupdf/fitz/base_hash.c
	gcc $(CFLAGS) -c -o base_hash.o $(JNI_DIR)/mupdf/fitz/base_hash.c

base_memory.o: $(JNI_DIR)/mupdf/fitz/base_memory.c
	gcc $(CFLAGS) -c -o base_memory.o $(JNI_DIR)/mupdf/fitz/base_memory.c

base_string.o: $(JNI_DIR)/mupdf/fitz/base_string.c
	gcc $(CFLAGS) -c -o base_string.o $(JNI_DIR)/mupdf/fitz/base_string.c

base_geometry.o: $(JNI_DIR)/mupdf/fitz/base_geometry.c
	gcc $(CFLAGS) -c -o base_geometry.o $(JNI_DIR)/mupdf/fitz/base_geometry.c


crypt_aes.o: $(JNI_DIR)/mupdf/fitz/crypt_aes.c
	gcc $(CFLAGS) -c -o crypt_aes.o $(JNI_DIR)/mupdf/fitz/crypt_aes.c

crypt_arc4.o: $(JNI_DIR)/mupdf/fitz/crypt_arc4.c
	gcc $(CFLAGS) -c -o crypt_arc4.o $(JNI_DIR)/mupdf/fitz/crypt_arc4.c

crypt_md5.o: $(JNI_DIR)/mupdf/fitz/crypt_md5.c
	gcc $(CFLAGS) -c -o crypt_md5.o $(JNI_DIR)/mupdf/fitz/crypt_md5.c

crypt_sha2.o: $(JNI_DIR)/mupdf/fitz/crypt_sha2.c
	gcc $(CFLAGS) -c -o crypt_sha2.o $(JNI_DIR)/mupdf/fitz/crypt_sha2.c


stm_buffer.o: $(JNI_DIR)/mupdf/fitz/stm_buffer.c
	gcc $(CFLAGS) -c -o stm_buffer.o $(JNI_DIR)/mupdf/fitz/stm_buffer.c

stm_open.o: $(JNI_DIR)/mupdf/fitz/stm_open.c
	gcc $(CFLAGS) -c -o stm_open.o $(JNI_DIR)/mupdf/fitz/stm_open.c

stm_read.o: $(JNI_DIR)/mupdf/fitz/stm_read.c
	gcc $(CFLAGS) -c -o stm_read.o $(JNI_DIR)/mupdf/fitz/stm_read.c


filt_basic.o: $(JNI_DIR)/mupdf/fitz/filt_basic.c
	gcc $(CFLAGS) -c -o filt_basic.o $(JNI_DIR)/mupdf/fitz/filt_basic.c

filt_dctd.o: $(JNI_DIR)/mupdf/fitz/filt_dctd.c
	gcc $(CFLAGS) -c -o filt_dctd.o $(JNI_DIR)/mupdf/fitz/filt_dctd.c

filt_faxd.o: $(JNI_DIR)/mupdf/fitz/filt_faxd.c
	gcc $(CFLAGS) -c -o filt_faxd.o $(JNI_DIR)/mupdf/fitz/filt_faxd.c

filt_flate.o: $(JNI_DIR)/mupdf/fitz/filt_flate.c
	gcc $(CFLAGS) -c -o filt_flate.o $(JNI_DIR)/mupdf/fitz/filt_flate.c

filt_lzwd.o: $(JNI_DIR)/mupdf/fitz/filt_lzwd.c
	gcc $(CFLAGS) -c -o filt_lzwd.o $(JNI_DIR)/mupdf/fitz/filt_lzwd.c

filt_predict.o: $(JNI_DIR)/mupdf/fitz/filt_predict.c
	gcc $(CFLAGS) -c -o filt_predict.o $(JNI_DIR)/mupdf/fitz/filt_predict.c

filt_jbig2d.o: $(JNI_DIR)/mupdf/fitz/filt_jbig2d.c
	gcc $(CFLAGS) -c -o filt_jbig2d.o $(JNI_DIR)/mupdf/fitz/filt_jbig2d.c


res_colorspace.o: $(JNI_DIR)/mupdf/fitz/res_colorspace.c
	gcc $(CFLAGS) -c -o res_colorspace.o $(JNI_DIR)/mupdf/fitz/res_colorspace.c

res_font.o: $(JNI_DIR)/mupdf/fitz/res_font.c
	gcc $(CFLAGS) -c -o res_font.o $(JNI_DIR)/mupdf/fitz/res_font.c

res_pixmap.o: $(JNI_DIR)/mupdf/fitz/res_pixmap.c
	gcc $(CFLAGS) -c -o res_pixmap.o $(JNI_DIR)/mupdf/fitz/res_pixmap.c

res_shade.o: $(JNI_DIR)/mupdf/fitz/res_shade.c
	gcc $(CFLAGS) -c -o res_shade.o $(JNI_DIR)/mupdf/fitz/res_shade.c

res_text.o: $(JNI_DIR)/mupdf/fitz/res_text.c
	gcc $(CFLAGS) -c -o res_text.o $(JNI_DIR)/mupdf/fitz/res_text.c

res_path.o: $(JNI_DIR)/mupdf/fitz/res_path.c
	gcc $(CFLAGS) -c -o res_path.o $(JNI_DIR)/mupdf/fitz/res_path.c

res_bitmap.o: $(JNI_DIR)/mupdf/fitz/res_bitmap.c
	gcc $(CFLAGS) -c -o res_bitmap.o $(JNI_DIR)/mupdf/fitz/res_bitmap.c

res_store.o: $(JNI_DIR)/mupdf/fitz/res_store.c
	gcc $(CFLAGS) -c -o res_store.o $(JNI_DIR)/mupdf/fitz/res_store.c


image_jpx.o: $(JNI_DIR)/mupdf/fitz/image_jpx.c
	gcc $(CFLAGS) -c -o image_jpx.o $(JNI_DIR)/mupdf/fitz/image_jpx.c


dev_list.o: $(JNI_DIR)/mupdf/fitz/dev_list.c
	gcc $(CFLAGS) -c -o dev_list.o $(JNI_DIR)/mupdf/fitz/dev_list.c

dev_text.o: $(JNI_DIR)/mupdf/fitz/dev_text.c
	gcc $(CFLAGS) -c -o dev_text.o $(JNI_DIR)/mupdf/fitz/dev_text.c

dev_bbox.o: $(JNI_DIR)/mupdf/fitz/dev_bbox.c
	gcc $(CFLAGS) -c -o dev_bbox.o $(JNI_DIR)/mupdf/fitz/dev_bbox.c

dev_null.o: $(JNI_DIR)/mupdf/fitz/dev_null.c
	gcc $(CFLAGS) -c -o dev_null.o $(JNI_DIR)/mupdf/fitz/dev_null.c


apv_doc_document.o: $(JNI_DIR)/mupdf/fitz/apv_doc_document.c
	gcc $(CFLAGS) -c -o apv_doc_document.o $(JNI_DIR)/mupdf/fitz/apv_doc_document.c

doc_link.o: $(JNI_DIR)/mupdf/fitz/doc_link.c
	gcc $(CFLAGS) -c -o doc_link.o $(JNI_DIR)/mupdf/fitz/doc_link.c



# FITZDRAW

libfitzdraw.a: $(FITZ_DRAW_OBJS)
	ar rcs libfitzdraw.a $(FITZ_DRAW_OBJS)

draw_device.o: $(JNI_DIR)/mupdf/draw/draw_device.c
	gcc $(CFLAGS) -c -o draw_device.o $(JNI_DIR)/mupdf/draw/draw_device.c

draw_blend.o: $(JNI_DIR)/mupdf/draw/draw_blend.c
	gcc $(CFLAGS) -c -o draw_blend.o $(JNI_DIR)/mupdf/draw/draw_blend.c

draw_glyph.o: $(JNI_DIR)/mupdf/draw/draw_glyph.c
	gcc $(CFLAGS) -c -o draw_glyph.o $(JNI_DIR)/mupdf/draw/draw_glyph.c

draw_affine.o: $(JNI_DIR)/mupdf/draw/draw_affine.c
	gcc $(CFLAGS) -c -o draw_affine.o $(JNI_DIR)/mupdf/draw/draw_affine.c

draw_scale.o: $(JNI_DIR)/mupdf/draw/draw_scale.c
	gcc $(CFLAGS) -c -o draw_scale.o $(JNI_DIR)/mupdf/draw/draw_scale.c

draw_unpack.o: $(JNI_DIR)/mupdf/draw/draw_unpack.c
	gcc $(CFLAGS) -c -o draw_unpack.o $(JNI_DIR)/mupdf/draw/draw_unpack.c

draw_mesh.o: $(JNI_DIR)/mupdf/draw/draw_mesh.c
	gcc $(CFLAGS) -c -o draw_mesh.o $(JNI_DIR)/mupdf/draw/draw_mesh.c

draw_path.o: $(JNI_DIR)/mupdf/draw/draw_path.c
	gcc $(CFLAGS) -c -o draw_path.o $(JNI_DIR)/mupdf/draw/draw_path.c

draw_paint.o: $(JNI_DIR)/mupdf/draw/draw_paint.c
	gcc $(CFLAGS) -c -o draw_paint.o $(JNI_DIR)/mupdf/draw/draw_paint.c

draw_edge.o: $(JNI_DIR)/mupdf/draw/draw_edge.c
	gcc $(CFLAGS) -c -o draw_edge.o $(JNI_DIR)/mupdf/draw/draw_edge.c


# MUPDF

libpdf.a: $(PDF_OBJS)
	ar rcs libpdf.a $(PDF_OBJS)


apv_pdf_debug.o: $(JNI_DIR)/mupdf/pdf/apv_pdf_debug.c
	gcc $(CFLAGS) -c -o apv_pdf_debug.o $(JNI_DIR)/mupdf/pdf/apv_pdf_debug.c

pdf_lex.o: $(JNI_DIR)/mupdf/pdf/pdf_lex.c
	gcc $(CFLAGS) -c -o pdf_lex.o $(JNI_DIR)/mupdf/pdf/pdf_lex.c

pdf_nametree.o: $(JNI_DIR)/mupdf/pdf/pdf_nametree.c
	gcc $(CFLAGS) -c -o pdf_nametree.o $(JNI_DIR)/mupdf/pdf/pdf_nametree.c

pdf_parse.o: $(JNI_DIR)/mupdf/pdf/pdf_parse.c
	gcc $(CFLAGS) -c -o pdf_parse.o $(JNI_DIR)/mupdf/pdf/pdf_parse.c

pdf_repair.o: $(JNI_DIR)/mupdf/pdf/pdf_repair.c
	gcc $(CFLAGS) -c -o pdf_repair.o $(JNI_DIR)/mupdf/pdf/pdf_repair.c

pdf_stream.o: $(JNI_DIR)/mupdf/pdf/pdf_stream.c
	gcc $(CFLAGS) -c -o pdf_stream.o $(JNI_DIR)/mupdf/pdf/pdf_stream.c

pdf_xref.o: $(JNI_DIR)/mupdf/pdf/pdf_xref.c
	gcc $(CFLAGS) -c -o pdf_xref.o $(JNI_DIR)/mupdf/pdf/pdf_xref.c

pdf_xref_aux.o: $(JNI_DIR)/mupdf/pdf/pdf_xref_aux.c
	gcc $(CFLAGS) -c -o pdf_xref_aux.o $(JNI_DIR)/mupdf/pdf/pdf_xref_aux.c

pdf_annot.o: $(JNI_DIR)/mupdf/pdf/pdf_annot.c
	gcc $(CFLAGS) -c -o pdf_annot.o $(JNI_DIR)/mupdf/pdf/pdf_annot.c

pdf_outline.o: $(JNI_DIR)/mupdf/pdf/pdf_outline.c
	gcc $(CFLAGS) -c -o pdf_outline.o $(JNI_DIR)/mupdf/pdf/pdf_outline.c

pdf_cmap.o: $(JNI_DIR)/mupdf/pdf/pdf_cmap.c
	gcc $(CFLAGS) -c -o pdf_cmap.o $(JNI_DIR)/mupdf/pdf/pdf_cmap.c

pdf_cmap_parse.o: $(JNI_DIR)/mupdf/pdf/pdf_cmap_parse.c
	gcc $(CFLAGS) -c -o pdf_cmap_parse.o $(JNI_DIR)/mupdf/pdf/pdf_cmap_parse.c

pdf_cmap_load.o: $(JNI_DIR)/mupdf/pdf/pdf_cmap_load.c
	gcc $(CFLAGS) -c -o pdf_cmap_load.o $(JNI_DIR)/mupdf/pdf/pdf_cmap_load.c

pdf_cmap_table.o: $(JNI_DIR)/mupdf/pdf/pdf_cmap_table.c
	gcc $(CFLAGS) -I$(JNI_DIR)/mupdf/pdf -c -o pdf_cmap_table.o $(JNI_DIR)/mupdf/pdf/pdf_cmap_table.c

pdf_encoding.o: $(JNI_DIR)/mupdf/pdf/pdf_encoding.c
	gcc $(CFLAGS) -c -o pdf_encoding.o $(JNI_DIR)/mupdf/pdf/pdf_encoding.c

pdf_unicode.o: $(JNI_DIR)/mupdf/pdf/pdf_unicode.c
	gcc $(CFLAGS) -c -o pdf_unicode.o $(JNI_DIR)/mupdf/pdf/pdf_unicode.c

pdf_font.o: $(JNI_DIR)/mupdf/pdf/pdf_font.c
	gcc $(CFLAGS) -c -o pdf_font.o $(JNI_DIR)/mupdf/pdf/pdf_font.c

pdf_type3.o: $(JNI_DIR)/mupdf/pdf/pdf_type3.c
	gcc $(CFLAGS) -c -o pdf_type3.o $(JNI_DIR)/mupdf/pdf/pdf_type3.c

pdf_metrics.o: $(JNI_DIR)/mupdf/pdf/pdf_metrics.c
	gcc $(CFLAGS) -c -o pdf_metrics.o $(JNI_DIR)/mupdf/pdf/pdf_metrics.c

pdf_fontfile.o: $(JNI_DIR)/mupdf/pdf/pdf_fontfile.c
	gcc $(CFLAGS) -c -o pdf_fontfile.o $(JNI_DIR)/mupdf/pdf/pdf_fontfile.c

pdf_function.o: $(JNI_DIR)/mupdf/pdf/pdf_function.c
	gcc $(CFLAGS) -c -o pdf_function.o $(JNI_DIR)/mupdf/pdf/pdf_function.c

pdf_colorspace.o: $(JNI_DIR)/mupdf/pdf/pdf_colorspace.c
	gcc $(CFLAGS) -c -o pdf_colorspace.o $(JNI_DIR)/mupdf/pdf/pdf_colorspace.c

pdf_image.o: $(JNI_DIR)/mupdf/pdf/pdf_image.c
	gcc $(CFLAGS) -c -o pdf_image.o $(JNI_DIR)/mupdf/pdf/pdf_image.c

pdf_pattern.o: $(JNI_DIR)/mupdf/pdf/pdf_pattern.c
	gcc $(CFLAGS) -c -o pdf_pattern.o $(JNI_DIR)/mupdf/pdf/pdf_pattern.c

pdf_shade.o: $(JNI_DIR)/mupdf/pdf/pdf_shade.c
	gcc $(CFLAGS) -c -o pdf_shade.o $(JNI_DIR)/mupdf/pdf/pdf_shade.c

pdf_object.o: $(JNI_DIR)/mupdf/pdf/pdf_object.c
	gcc $(CFLAGS) -c -o pdf_object.o $(JNI_DIR)/mupdf/pdf/pdf_object.c

pdf_xobject.o: $(JNI_DIR)/mupdf/pdf/pdf_xobject.c
	gcc $(CFLAGS) -c -o pdf_xobject.o $(JNI_DIR)/mupdf/pdf/pdf_xobject.c

pdf_interpret.o: $(JNI_DIR)/mupdf/pdf/pdf_interpret.c
	gcc $(CFLAGS) -c -o pdf_interpret.o $(JNI_DIR)/mupdf/pdf/pdf_interpret.c

pdf_page.o: $(JNI_DIR)/mupdf/pdf/pdf_page.c
	gcc $(CFLAGS) -c -o pdf_page.o $(JNI_DIR)/mupdf/pdf/pdf_page.c

pdf_store.o: $(JNI_DIR)/mupdf/pdf/pdf_store.c
	gcc $(CFLAGS) -c -o pdf_store.o $(JNI_DIR)/mupdf/pdf/pdf_store.c

pdf_crypt.o: $(JNI_DIR)/mupdf/pdf/pdf_crypt.c
	gcc $(CFLAGS) -c -o pdf_crypt.o $(JNI_DIR)/mupdf/pdf/pdf_crypt.c





# FREETYPE

libfreetype.a: $(FREETYPE_OBJS)
	ar rcs libfreetype.a $(FREETYPE_OBJS)

ftsystem.o: $(JNI_DIR)/freetype/src/base/ftsystem.c
	gcc $(CFLAGS) -c -o ftsystem.o $(JNI_DIR)/freetype/src/base/ftsystem.c

ftinit.o: $(JNI_DIR)/freetype/src/base/ftinit.c
	gcc $(CFLAGS) -c -o ftinit.o $(JNI_DIR)/freetype/src/base/ftinit.c

ftdebug.o: $(JNI_DIR)/freetype/src/base/ftdebug.c
	gcc $(CFLAGS) -c -o ftdebug.o $(JNI_DIR)/freetype/src/base/ftdebug.c

ftbase.o: $(JNI_DIR)/freetype/src/base/ftbase.c
	gcc $(CFLAGS) -c -o ftbase.o $(JNI_DIR)/freetype/src/base/ftbase.c

ftbbox.o: $(JNI_DIR)/freetype/src/base/ftbbox.c
	gcc $(CFLAGS) -c -o ftbbox.o $(JNI_DIR)/freetype/src/base/ftbbox.c

ftglyph.o: $(JNI_DIR)/freetype/src/base/ftglyph.c
	gcc $(CFLAGS) -c -o ftglyph.o $(JNI_DIR)/freetype/src/base/ftglyph.c

ftbitmap.o: $(JNI_DIR)/freetype/src/base/ftbitmap.c
	gcc $(CFLAGS) -c -o ftbitmap.o $(JNI_DIR)/freetype/src/base/ftbitmap.c

ftcid.o: $(JNI_DIR)/freetype/src/base/ftcid.c
	gcc $(CFLAGS) -c -o ftcid.o $(JNI_DIR)/freetype/src/base/ftcid.c

ftfstype.o: $(JNI_DIR)/freetype/src/base/ftfstype.c
	gcc $(CFLAGS) -c -o ftfstype.o $(JNI_DIR)/freetype/src/base/ftfstype.c

ftgasp.o: $(JNI_DIR)/freetype/src/base/ftgasp.c
	gcc $(CFLAGS) -c -o ftgasp.o $(JNI_DIR)/freetype/src/base/ftgasp.c

ftgxval.o: $(JNI_DIR)/freetype/src/base/ftgxval.c
	gcc $(CFLAGS) -c -o ftgxval.o $(JNI_DIR)/freetype/src/base/ftgxval.c

ftlcdfil.o: $(JNI_DIR)/freetype/src/base/ftlcdfil.c
	gcc $(CFLAGS) -c -o ftlcdfil.o $(JNI_DIR)/freetype/src/base/ftlcdfil.c

ftmm.o: $(JNI_DIR)/freetype/src/base/ftmm.c
	gcc $(CFLAGS) -c -o ftmm.o $(JNI_DIR)/freetype/src/base/ftmm.c

ftotval.o: $(JNI_DIR)/freetype/src/base/ftotval.c
	gcc $(CFLAGS) -c -o ftotval.o $(JNI_DIR)/freetype/src/base/ftotval.c

ftpatent.o: $(JNI_DIR)/freetype/src/base/ftpatent.c
	gcc $(CFLAGS) -c -o ftpatent.o $(JNI_DIR)/freetype/src/base/ftpatent.c

ftstroke.o: $(JNI_DIR)/freetype/src/base/ftstroke.c
	gcc $(CFLAGS) -c -o ftstroke.o $(JNI_DIR)/freetype/src/base/ftstroke.c

ftsynth.o: $(JNI_DIR)/freetype/src/base/ftsynth.c
	gcc $(CFLAGS) -c -o ftsynth.o $(JNI_DIR)/freetype/src/base/ftsynth.c

fttype1.o: $(JNI_DIR)/freetype/src/base/fttype1.c
	gcc $(CFLAGS) -c -o fttype1.o $(JNI_DIR)/freetype/src/base/fttype1.c

ftxf86.o: $(JNI_DIR)/freetype/src/base/ftxf86.c
	gcc $(CFLAGS) -c -o ftxf86.o $(JNI_DIR)/freetype/src/base/ftxf86.c

cff.o: $(JNI_DIR)/freetype/src/cff/cff.c
	gcc $(CFLAGS) -c -o cff.o $(JNI_DIR)/freetype/src/cff/cff.c

type1cid.o: $(JNI_DIR)/freetype/src/cid/type1cid.c
	gcc $(CFLAGS) -c -o type1cid.o $(JNI_DIR)/freetype/src/cid/type1cid.c

sfnt.o: $(JNI_DIR)/freetype/src/sfnt/sfnt.c
	gcc $(CFLAGS) -c -o sfnt.o $(JNI_DIR)/freetype/src/sfnt/sfnt.c

truetype.o: $(JNI_DIR)/freetype/src/truetype/truetype.c
	gcc $(CFLAGS) -c -o truetype.o $(JNI_DIR)/freetype/src/truetype/truetype.c

type1.o: $(JNI_DIR)/freetype/src/type1/type1.c
	gcc $(CFLAGS) -c -o type1.o $(JNI_DIR)/freetype/src/type1/type1.c

raster.o: $(JNI_DIR)/freetype/src/raster/raster.c
	gcc $(CFLAGS) -c -o raster.o $(JNI_DIR)/freetype/src/raster/raster.c

smooth.o: $(JNI_DIR)/freetype/src/smooth/smooth.c
	gcc $(CFLAGS) -c -o smooth.o $(JNI_DIR)/freetype/src/smooth/smooth.c

autofit.o: $(JNI_DIR)/freetype/src/autofit/autofit.c
	gcc $(CFLAGS) -c -o autofit.o $(JNI_DIR)/freetype/src/autofit/autofit.c

ftcache.o: $(JNI_DIR)/freetype/src/cache/ftcache.c
	gcc $(CFLAGS) -c -o ftcache.o $(JNI_DIR)/freetype/src/cache/ftcache.c

gxvalid.o: $(JNI_DIR)/freetype/src/gxvalid/gxvalid.c
	gcc $(CFLAGS) -c -o gxvalid.o $(JNI_DIR)/freetype/src/gxvalid/gxvalid.c

otvalid.o: $(JNI_DIR)/freetype/src/otvalid/otvalid.c
	gcc $(CFLAGS) -c -o otvalid.o $(JNI_DIR)/freetype/src/otvalid/otvalid.c

psaux.o: $(JNI_DIR)/freetype/src/psaux/psaux.c
	gcc $(CFLAGS) -c -o psaux.o $(JNI_DIR)/freetype/src/psaux/psaux.c

pshinter.o: $(JNI_DIR)/freetype/src/pshinter/pshinter.c
	gcc $(CFLAGS) -c -o pshinter.o $(JNI_DIR)/freetype/src/pshinter/pshinter.c

psnames.o: $(JNI_DIR)/freetype/src/psnames/psnames.c
	gcc $(CFLAGS) -c -o psnames.o $(JNI_DIR)/freetype/src/psnames/psnames.c


# JBIG2DEC


libjbig2dec.a: $(JBIG2DEC_OBJS)
	ar rcs libjbig2dec.a $(JBIG2DEC_OBJS)


jbig2.o: $(JNI_DIR)/jbig2dec/jbig2.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2.o $(JNI_DIR)/jbig2dec/jbig2.c

jbig2_arith.o: $(JNI_DIR)/jbig2dec/jbig2_arith.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_arith.o $(JNI_DIR)/jbig2dec/jbig2_arith.c

jbig2_arith_iaid.o: $(JNI_DIR)/jbig2dec/jbig2_arith_iaid.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_arith_iaid.o $(JNI_DIR)/jbig2dec/jbig2_arith_iaid.c

jbig2_arith_int.o: $(JNI_DIR)/jbig2dec/jbig2_arith_int.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_arith_int.o $(JNI_DIR)/jbig2dec/jbig2_arith_int.c

jbig2_generic.o: $(JNI_DIR)/jbig2dec/jbig2_generic.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_generic.o $(JNI_DIR)/jbig2dec/jbig2_generic.c

jbig2_halftone.o: $(JNI_DIR)/jbig2dec/jbig2_halftone.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_halftone.o $(JNI_DIR)/jbig2dec/jbig2_halftone.c

jbig2_huffman.o: $(JNI_DIR)/jbig2dec/jbig2_huffman.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_huffman.o $(JNI_DIR)/jbig2dec/jbig2_huffman.c

jbig2_image.o: $(JNI_DIR)/jbig2dec/jbig2_image.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_image.o $(JNI_DIR)/jbig2dec/jbig2_image.c

jbig2_image_pbm.o: $(JNI_DIR)/jbig2dec/jbig2_image_pbm.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_image_pbm.o $(JNI_DIR)/jbig2dec/jbig2_image_pbm.c

jbig2_metadata.o: $(JNI_DIR)/jbig2dec/jbig2_metadata.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_metadata.o $(JNI_DIR)/jbig2dec/jbig2_metadata.c

jbig2_mmr.o: $(JNI_DIR)/jbig2dec/jbig2_mmr.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_mmr.o $(JNI_DIR)/jbig2dec/jbig2_mmr.c

jbig2_page.o: $(JNI_DIR)/jbig2dec/jbig2_page.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_page.o $(JNI_DIR)/jbig2dec/jbig2_page.c

jbig2_refinement.o: $(JNI_DIR)/jbig2dec/jbig2_refinement.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_refinement.o $(JNI_DIR)/jbig2dec/jbig2_refinement.c

jbig2_segment.o: $(JNI_DIR)/jbig2dec/jbig2_segment.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_segment.o $(JNI_DIR)/jbig2dec/jbig2_segment.c

jbig2_symbol_dict.o: $(JNI_DIR)/jbig2dec/jbig2_symbol_dict.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_symbol_dict.o $(JNI_DIR)/jbig2dec/jbig2_symbol_dict.c

jbig2_text.o: $(JNI_DIR)/jbig2dec/jbig2_text.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2_text.o $(JNI_DIR)/jbig2dec/jbig2_text.c

jbig2dec.o: $(JNI_DIR)/jbig2dec/jbig2dec.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o jbig2dec.o $(JNI_DIR)/jbig2dec/jbig2dec.c

sha1.o: $(JNI_DIR)/jbig2dec/sha1.c
	gcc $(CFLAGS) -DHAVE_CONFIG_H -c -o sha1.o $(JNI_DIR)/jbig2dec/sha1.c


# JPEG

libjpeg.a: $(JPEG_OBJS)
	ar rcs libjpeg.a $(JPEG_OBJS)

jaricom.o: $(JNI_DIR)/jpeg/jaricom.c
	gcc $(CFLAGS) -c -o jaricom.o $(JNI_DIR)/jpeg/jaricom.c

jcapimin.o: $(JNI_DIR)/jpeg/jcapimin.c
	gcc $(CFLAGS) -c -o jcapimin.o $(JNI_DIR)/jpeg/jcapimin.c

jcapistd.o: $(JNI_DIR)/jpeg/jcapistd.c
	gcc $(CFLAGS) -c -o jcapistd.o $(JNI_DIR)/jpeg/jcapistd.c

jcarith.o: $(JNI_DIR)/jpeg/jcarith.c
	gcc $(CFLAGS) -c -o jcarith.o $(JNI_DIR)/jpeg/jcarith.c

jccoefct.o: $(JNI_DIR)/jpeg/jccoefct.c
	gcc $(CFLAGS) -c -o jccoefct.o $(JNI_DIR)/jpeg/jccoefct.c

jccolor.o: $(JNI_DIR)/jpeg/jccolor.c
	gcc $(CFLAGS) -c -o jccolor.o $(JNI_DIR)/jpeg/jccolor.c

jcdctmgr.o: $(JNI_DIR)/jpeg/jcdctmgr.c
	gcc $(CFLAGS) -c -o jcdctmgr.o $(JNI_DIR)/jpeg/jcdctmgr.c

jchuff.o: $(JNI_DIR)/jpeg/jchuff.c
	gcc $(CFLAGS) -c -o jchuff.o $(JNI_DIR)/jpeg/jchuff.c

jcinit.o: $(JNI_DIR)/jpeg/jcinit.c
	gcc $(CFLAGS) -c -o jcinit.o $(JNI_DIR)/jpeg/jcinit.c

jcmainct.o: $(JNI_DIR)/jpeg/jcmainct.c
	gcc $(CFLAGS) -c -o jcmainct.o $(JNI_DIR)/jpeg/jcmainct.c

jcmarker.o: $(JNI_DIR)/jpeg/jcmarker.c
	gcc $(CFLAGS) -c -o jcmarker.o $(JNI_DIR)/jpeg/jcmarker.c

jcmaster.o: $(JNI_DIR)/jpeg/jcmaster.c
	gcc $(CFLAGS) -c -o jcmaster.o $(JNI_DIR)/jpeg/jcmaster.c

jcomapi.o: $(JNI_DIR)/jpeg/jcomapi.c
	gcc $(CFLAGS) -c -o jcomapi.o $(JNI_DIR)/jpeg/jcomapi.c

jcparam.o: $(JNI_DIR)/jpeg/jcparam.c
	gcc $(CFLAGS) -c -o jcparam.o $(JNI_DIR)/jpeg/jcparam.c

jcprepct.o: $(JNI_DIR)/jpeg/jcprepct.c
	gcc $(CFLAGS) -c -o jcprepct.o $(JNI_DIR)/jpeg/jcprepct.c

jcsample.o: $(JNI_DIR)/jpeg/jcsample.c
	gcc $(CFLAGS) -c -o jcsample.o $(JNI_DIR)/jpeg/jcsample.c

jctrans.o: $(JNI_DIR)/jpeg/jctrans.c
	gcc $(CFLAGS) -c -o jctrans.o $(JNI_DIR)/jpeg/jctrans.c

jdapimin.o: $(JNI_DIR)/jpeg/jdapimin.c
	gcc $(CFLAGS) -c -o jdapimin.o $(JNI_DIR)/jpeg/jdapimin.c

jdapistd.o: $(JNI_DIR)/jpeg/jdapistd.c
	gcc $(CFLAGS) -c -o jdapistd.o $(JNI_DIR)/jpeg/jdapistd.c

jdarith.o: $(JNI_DIR)/jpeg/jdarith.c
	gcc $(CFLAGS) -c -o jdarith.o $(JNI_DIR)/jpeg/jdarith.c

jdatadst.o: $(JNI_DIR)/jpeg/jdatadst.c
	gcc $(CFLAGS) -c -o jdatadst.o $(JNI_DIR)/jpeg/jdatadst.c

jdatasrc.o: $(JNI_DIR)/jpeg/jdatasrc.c
	gcc $(CFLAGS) -c -o jdatasrc.o $(JNI_DIR)/jpeg/jdatasrc.c

jdcoefct.o: $(JNI_DIR)/jpeg/jdcoefct.c
	gcc $(CFLAGS) -c -o jdcoefct.o $(JNI_DIR)/jpeg/jdcoefct.c

jdcolor.o: $(JNI_DIR)/jpeg/jdcolor.c
	gcc $(CFLAGS) -c -o jdcolor.o $(JNI_DIR)/jpeg/jdcolor.c

jddctmgr.o: $(JNI_DIR)/jpeg/jddctmgr.c
	gcc $(CFLAGS) -c -o jddctmgr.o $(JNI_DIR)/jpeg/jddctmgr.c

jdhuff.o: $(JNI_DIR)/jpeg/jdhuff.c
	gcc $(CFLAGS) -c -o jdhuff.o $(JNI_DIR)/jpeg/jdhuff.c

jdinput.o: $(JNI_DIR)/jpeg/jdinput.c
	gcc $(CFLAGS) -c -o jdinput.o $(JNI_DIR)/jpeg/jdinput.c

jdmainct.o: $(JNI_DIR)/jpeg/jdmainct.c
	gcc $(CFLAGS) -c -o jdmainct.o $(JNI_DIR)/jpeg/jdmainct.c

jdmarker.o: $(JNI_DIR)/jpeg/jdmarker.c
	gcc $(CFLAGS) -c -o jdmarker.o $(JNI_DIR)/jpeg/jdmarker.c

jdmaster.o: $(JNI_DIR)/jpeg/jdmaster.c
	gcc $(CFLAGS) -c -o jdmaster.o $(JNI_DIR)/jpeg/jdmaster.c

jdmerge.o: $(JNI_DIR)/jpeg/jdmerge.c
	gcc $(CFLAGS) -c -o jdmerge.o $(JNI_DIR)/jpeg/jdmerge.c

jdpostct.o: $(JNI_DIR)/jpeg/jdpostct.c
	gcc $(CFLAGS) -c -o jdpostct.o $(JNI_DIR)/jpeg/jdpostct.c

jdsample.o: $(JNI_DIR)/jpeg/jdsample.c
	gcc $(CFLAGS) -c -o jdsample.o $(JNI_DIR)/jpeg/jdsample.c

jdtrans.o: $(JNI_DIR)/jpeg/jdtrans.c
	gcc $(CFLAGS) -c -o jdtrans.o $(JNI_DIR)/jpeg/jdtrans.c

jerror.o: $(JNI_DIR)/jpeg/jerror.c
	gcc $(CFLAGS) -c -o jerror.o $(JNI_DIR)/jpeg/jerror.c

jfdctflt.o: $(JNI_DIR)/jpeg/jfdctflt.c
	gcc $(CFLAGS) -c -o jfdctflt.o $(JNI_DIR)/jpeg/jfdctflt.c

jfdctfst.o: $(JNI_DIR)/jpeg/jfdctfst.c
	gcc $(CFLAGS) -c -o jfdctfst.o $(JNI_DIR)/jpeg/jfdctfst.c

jfdctint.o: $(JNI_DIR)/jpeg/jfdctint.c
	gcc $(CFLAGS) -c -o jfdctint.o $(JNI_DIR)/jpeg/jfdctint.c

jidctflt.o: $(JNI_DIR)/jpeg/jidctflt.c
	gcc $(CFLAGS) -c -o jidctflt.o $(JNI_DIR)/jpeg/jidctflt.c

jidctfst.o: $(JNI_DIR)/jpeg/jidctfst.c
	gcc $(CFLAGS) -c -o jidctfst.o $(JNI_DIR)/jpeg/jidctfst.c

jidctint.o: $(JNI_DIR)/jpeg/jidctint.c
	gcc $(CFLAGS) -c -o jidctint.o $(JNI_DIR)/jpeg/jidctint.c

jquant1.o: $(JNI_DIR)/jpeg/jquant1.c
	gcc $(CFLAGS) -c -o jquant1.o $(JNI_DIR)/jpeg/jquant1.c

jquant2.o: $(JNI_DIR)/jpeg/jquant2.c
	gcc $(CFLAGS) -c -o jquant2.o $(JNI_DIR)/jpeg/jquant2.c

jutils.o: $(JNI_DIR)/jpeg/jutils.c
	gcc $(CFLAGS) -c -o jutils.o $(JNI_DIR)/jpeg/jutils.c

jmemmgr.o: $(JNI_DIR)/jpeg/jmemmgr.c
	gcc $(CFLAGS) -c -o jmemmgr.o $(JNI_DIR)/jpeg/jmemmgr.c

jmemnobs.o: $(JNI_DIR)/jpeg/jmemnobs.c
	gcc $(CFLAGS) -c -o jmemnobs.o $(JNI_DIR)/jpeg/jmemnobs.c




# OPENJPEG


libopenjpeg.a: $(OPENJPEG_LIBS)
	ar rcs libopenjpeg.a $(OPENJPEG_LIBS)


bio.o: $(JNI_DIR)/openjpeg/bio.c
	gcc $(CFLAGS) -c -o bio.o $(JNI_DIR)/openjpeg/bio.c

cio.o: $(JNI_DIR)/openjpeg/cio.c
	gcc $(CFLAGS) -c -o cio.o $(JNI_DIR)/openjpeg/cio.c

dwt.o: $(JNI_DIR)/openjpeg/dwt.c
	gcc $(CFLAGS) -c -o dwt.o $(JNI_DIR)/openjpeg/dwt.c

event.o: $(JNI_DIR)/openjpeg/event.c
	gcc $(CFLAGS) -c -o event.o $(JNI_DIR)/openjpeg/event.c

image.o: $(JNI_DIR)/openjpeg/image.c
	gcc $(CFLAGS) -c -o image.o $(JNI_DIR)/openjpeg/image.c

j2k.o: $(JNI_DIR)/openjpeg/j2k.c
	gcc $(CFLAGS) -c -o j2k.o $(JNI_DIR)/openjpeg/j2k.c

j2k_lib.o: $(JNI_DIR)/openjpeg/j2k_lib.c
	gcc $(CFLAGS) -c -o j2k_lib.o $(JNI_DIR)/openjpeg/j2k_lib.c

jp2.o: $(JNI_DIR)/openjpeg/jp2.c
	gcc $(CFLAGS) -c -o jp2.o $(JNI_DIR)/openjpeg/jp2.c

jpt.o: $(JNI_DIR)/openjpeg/jpt.c
	gcc $(CFLAGS) -c -o jpt.o $(JNI_DIR)/openjpeg/jpt.c

mct.o: $(JNI_DIR)/openjpeg/mct.c
	gcc $(CFLAGS) -c -o mct.o $(JNI_DIR)/openjpeg/mct.c

mqc.o: $(JNI_DIR)/openjpeg/mqc.c
	gcc $(CFLAGS) -c -o mqc.o $(JNI_DIR)/openjpeg/mqc.c

openjpeg.o: $(JNI_DIR)/openjpeg/openjpeg.c
	gcc $(CFLAGS) -c -o openjpeg.o $(JNI_DIR)/openjpeg/openjpeg.c

pi.o: $(JNI_DIR)/openjpeg/pi.c
	gcc $(CFLAGS) -c -o pi.o $(JNI_DIR)/openjpeg/pi.c

raw.o: $(JNI_DIR)/openjpeg/raw.c
	gcc $(CFLAGS) -c -o raw.o $(JNI_DIR)/openjpeg/raw.c

t1.o: $(JNI_DIR)/openjpeg/t1.c
	gcc $(CFLAGS) -c -o t1.o $(JNI_DIR)/openjpeg/t1.c

t1_generate_luts.o: $(JNI_DIR)/openjpeg/t1_generate_luts.c
	gcc $(CFLAGS) -c -o t1_generate_luts.o $(JNI_DIR)/openjpeg/t1_generate_luts.c

t2.o: $(JNI_DIR)/openjpeg/t2.c
	gcc $(CFLAGS) -c -o t2.o $(JNI_DIR)/openjpeg/t2.c

tcd.o: $(JNI_DIR)/openjpeg/tcd.c
	gcc $(CFLAGS) -c -o tcd.o $(JNI_DIR)/openjpeg/tcd.c

tgt.o: $(JNI_DIR)/openjpeg/tgt.c
	gcc $(CFLAGS) -c -o tgt.o $(JNI_DIR)/openjpeg/tgt.c

cidx_manager.o: $(JNI_DIR)/openjpeg/cidx_manager.c
	gcc $(CFLAGS) -c -o cidx_manager.o $(JNI_DIR)/openjpeg/cidx_manager.c

tpix_manager.o: $(JNI_DIR)/openjpeg/tpix_manager.c
	gcc $(CFLAGS) -c -o tpix_manager.o $(JNI_DIR)/openjpeg/tpix_manager.c

ppix_manager.o: $(JNI_DIR)/openjpeg/ppix_manager.c
	gcc $(CFLAGS) -c -o ppix_manager.o $(JNI_DIR)/openjpeg/ppix_manager.c

thix_manager.o: $(JNI_DIR)/openjpeg/thix_manager.c
	gcc $(CFLAGS) -c -o thix_manager.o $(JNI_DIR)/openjpeg/thix_manager.c

phix_manager.o: $(JNI_DIR)/openjpeg/phix_manager.c
	gcc $(CFLAGS) -c -o phix_manager.o $(JNI_DIR)/openjpeg/phix_manager.c






apv.o: ../jni/pdfview2/apvcore.c ../jni/pdfview2/apvcore.h
	gcc $(CFLAGS) -c -o apv.o ../jni/pdfview2/apvcore.c

mupdf.o: ../jni/pdfview2/mupdf/fitz

clean:
	@rm -fv *.o
	@rm -fv *.a
	@rm -fv aptn
