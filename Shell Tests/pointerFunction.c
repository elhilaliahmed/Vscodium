#include <stdio.h>

// function sum's type is int(int, int)
int sum(int a, int b) {
    return a + b;
}

// this function type's is int(int, int)
int squarediff(int a, int b) {
    return (a + b) * (a - b);
}

// function pro's type is double(double, double)
double pro(double a, double b) {
    return a * b;
}

// this function returns int and takes two ints
int i_ii_ptr(int, int);

// this function returns int* and take two ints
int *i_ii_ptr(int, int);

// this function is function pointer thatpoints to a function
// it returns an int and take two ints
int (*i_ii_ptr)(int, int);

// now it become a type, a function pointer type
// this type points to a function that returns an int and take two ints
typedef int (*i_ii_ptr)(int, int);

void call(i_ii_ptr func, int a, int b) {
    return func(a, b);
}

int main() {
    printf("8 + 4 = %d\n", call(sum, 8, 4));
    printf("8 + 4 = %d\n", call(squarediff, 8, 4));
    return 0;
}