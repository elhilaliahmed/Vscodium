#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (int argc, char* argv[]) {

    char str[] = "L-et's -----break -this string into pieces";

    char* piece = strtok(str, " -");

    while (piece != NULL) {
        printf("%s\n", piece);
        piece = strtok(NULL, "- ");
    }

/*     char*  piece = NULL;
    
    piece = strtok(str," ");
    printf("%s\n", piece);

    piece = strtok(NULL, " ");
    printf("%s\n", piece);

    piece = strtok(NULL, " ");
    printf("%s\n", piece);

    piece = strtok(NULL, " ");
    printf("%s\n", piece);

    piece = strtok(NULL, " ");
    printf("%s\n", piece);

    piece = strtok(NULL, " ");
    printf("%s\n", piece); */

  return 0;  
}