#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

/*
    This program is intended to show how to print the content of a file
    a bit better than what we did in the previous example: print-textfile-bad.c

    What makes it better is:
        can print all files given on command line (one by one, interactively)
        checks return values on open, close, read, write and acts accordingly
*/

#define READ_BUF_SIZE 100

enum {
    OK,
    FAILED_OPEN_FILE,
    PRINT_FAILURE,
    CLOSE_FAILURE
} return_values;

int
print_file(char* fileName) {
    char buf[READ_BUF_SIZE];
    FILE* fp;
    int ret;

    fp = fopen(fileName, "r");
    if (fp == NULL) {
        return FAILED_OPEN_FILE;
    }

    while (fgets(buf, READ_BUF_SIZE, fp)) {
        ret = fprintf(stdout, "%s", buf);
        if (ret < 0 || (unsigned int) ret != strlen(buf)) {
            return PRINT_FAILURE;
        }
    }

    if (fclose(fp) != 0) {
        return CLOSE_FAILURE;
    }

    return OK;
}

int 
main(int argc, char** argv) {
    char* fileName;
    int ret;

    if (argc < 2) {
        fprintf(stderr, "Missing file argument\n");
        return 1;
    }

    for (int i = 1; i < argc; i++) {
        fileName = argv[i];
        if (argc > 2) {

            fprintf(stdout, ":: Press a key to show file: %s ::\n", fileName);
            ret = getchar();

            if (ret == EOF) {
                fprintf(stderr, "Failed reading command from user, bailing out\n");
                return 2;
            }
        }
        ret = print_file(fileName);
        if (ret) {

            if (ret == FAILED_OPEN_FILE) {
                printf("Failed reading file '%s'\n * %s\n", fileName, strerror(errno));
            }
            
            else if (ret == CLOSE_FAILURE) {
                printf("Failed closing file '%s'\n * %s\n", fileName, strerror(errno));
            }

            return ret;
        }
    }
    return 0;
}
