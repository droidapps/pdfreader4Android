
#include <stdio.h>

#include "apvcore.h"


void apv_log_print(const char *file, int line, int level, const char *fmt, ...) {
    printf("log\n");
}


int main(int argc, char *argv[]) {
    pdf_t *pdf = NULL;
    char *filename = NULL;

    if (argc != 2) {
        fprintf(stderr, "usage: aptn filename\n");
        return 1;
    }

    filename = argv[1];

    pdf = parse_pdf_file(filename, 0, NULL);
    printf("loaded pdf file\n");

/*
fz_pixmap *get_page_image_bitmap(
        pdf_t *pdf,
        int pageno, int zoom_pmil,
        int left, int top, int rotation,
        int skipImages,
        int width, int height)
*/

    fz_pixmap *pixmap = get_page_image_bitmap(pdf, 1, 1000, 0, 0, 0, 0, 256, 256);
    printf("got pixmap, w: %d, h: %d\n",
        (int) fz_pixmap_width(pdf->ctx, pixmap),
        (int) fz_pixmap_height(pdf->ctx, pixmap));

    free_pdf_t(pdf);

    return 0;
}


