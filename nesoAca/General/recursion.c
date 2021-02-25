#include <stdio.h>
#include <stdlib.h>

int fun(int n) {
    if (n == 1) return 1;
    else return n*fun(n-1);
}

int main(int argc, char* argv[]) {
    printf("%d", fun(atoi(argv[1])));
    return 0;
}