#include <stdio.h>
int add(int a, int b) {
    return a + b;
}

int mul(int a, int b, int c) {
    return a * b * c;
}

int main() {
    int a, b;

    int (*ptr)(int, int);
    ptr = add;
    a = ptr(10,20);
    b = mul(3,2,4);
    printf("%d, %d", a, b);

    return 0;
}