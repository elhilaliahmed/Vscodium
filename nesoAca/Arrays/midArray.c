#include <stdio.h>

int findMid(int* a, int size);

int* findMiddle(int* a, int size);

int main() {

    int a[] = {1, 2, 3, 4, 5};

    int n = sizeof(a) / sizeof(a[0]);

    int mid = findMid(a, n);
    int* middle = findMiddle(a, n);

    printf("%d\n", findMid(a, n));
    printf("%d\n", *findMiddle(a, n));

    return 0;
}

int findMid(int a[], int size) {
    return a[size / 2];
}

int* findMiddle (int* a, int size) {
    return &a[size / 2];
}