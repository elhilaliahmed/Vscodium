#include <stdio.h>
#include <stdlib.h>
int main () {

    int x = 4;
    int array[5];

    array[-1] = 100;
    *(array - 1) = 500;

    printf("%d", x);
    return 0 ;
} 