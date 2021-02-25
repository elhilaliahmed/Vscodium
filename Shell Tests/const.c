#include <stdio.h>

void modifyArray(const int[]);

int main() {
    int numbers[3] = {2,3,5};
    modifyArray(numbers);
    return 0;
}

void modifyArray(const int numbers[]) {
    int x = 0;
    for(x = 0; x < 3; x++) {
        numbers[x] = numbers[x];
    }
}