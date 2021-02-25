#include <stdio.h>




int main() {
    
    int a[] = {0, 1, 2, 3, 4, 15};

    int sum = 0, *p;

    int len = sizeof(a) / sizeof(int);
    for (p = a; p < &a[(sizeof(a) / sizeof(int))]; p++) {
        sum += *p;
    }

    printf("Sum is: %d\n", sum);
    printf("Sum is: %d\n", len);
    sum = 0;

    for (p = a; p < a + len; p++) {
        sum += *p;
    }

    printf("Sum is: %d\n", sum);
    printf("Sum is: %d\n", len);
    return 0;
}