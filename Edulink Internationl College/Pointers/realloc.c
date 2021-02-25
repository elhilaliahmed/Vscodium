#include <stdio.h>
#include <stdlib.h>

int main() {
    int* ptr;

    ptr = (int*)calloc(5, sizeof(int));

    if (ptr != NULL) {
        *(ptr + 0) = 1;
        *(ptr + 1) = 2;
        *(ptr + 2) = 4;
        *(ptr + 3) = 8;
        *(ptr + 4) = 16;

        // ptr[5] = 32 wouldn't assing anything
        // so let's extend the memory

        ptr = (int*) realloc(ptr, 7 * sizeof(int));
        if (ptr != NULL) {
            printf("Now we have enough memory...\n");
            
            ptr[5] = 32; // now it is legal
            *(ptr + 6) = 64;

            printf("Printing all the elements stored in the array\n");

            for (int i = 0; i < 7; i++) {
                printf("ptr[%d] holds the value: %d\n", i, ptr[i]);
            }

            // realloc(ptr, 0);
            free(ptr); // same as free(ptr); just fancier!
            return 0;
        }

    }

    printf("Allocating memory was not successful\n");
    return 1;
}