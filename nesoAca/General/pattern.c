#include <stdio.h>

int main() {



    for (int i = 0; i < 7; i++) {

        printf("%d", i);

        for (int j = 0; j < 7 - i; j++) {
            printf(" ");
        }
        printf("%d", i);

        for (int j = 0; j < 2 * i - 1; j++) {
            printf("*");
        }
        printf("%d", i);

        printf("\n");

    }

    return 0;
}