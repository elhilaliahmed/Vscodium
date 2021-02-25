#include <stdio.h>

int add(int*, int);

int main(int argc, char* argv[]) {
    
    int a[] = {1, 2, 3, 4, 10, 5};
    int len = sizeof(a) / sizeof(a[0]);

    printf("%d", add(a, len));
    return 0;
}

int add(int* array, int length) {

    int sum = 0;

    for (int i = 0; i < length; i++) {
        sum += *array++;
    }
    
    return sum;
}