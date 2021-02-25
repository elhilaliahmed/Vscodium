#include <stdio.h>
#define length 5

int main() {


    int a[length], *p;

    printf("Enter 5 elements in the array: ", length);
    for (p = a; p <= a + length - 1; p++) {
        scanf("%d", p);
    }

    printf("Elements in normal order: \n");
    for (p = a; p < a + length; p++) {
        printf("%d ", *p);
    }

    printf("\n");

    printf("Elements in reverse order: \n");
    for (p = a + length - 1; p >= a; p--) {
        printf("%d ", *p);
    }

    return 0;
}