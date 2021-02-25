#include <stdio.h>

int* fun() {
    int i = 10;
    return &i;
}

int main() {
    int* p = fun();
    printf("%d ", *p);
}