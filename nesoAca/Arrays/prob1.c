#include <stdio.h>
#include <stdlib.h>

#define SIZE 7

int main(int argc, char *argv[]) {

    int seen[10] = {0};
    int number;
    char* num = {0};


    printf("Enter a number: ");
    scanf("%d", &number);
    printf("%c", *(num + 1));
    printf("%d", sizeof(num) / 4);
    return 0;
}

void repeatedNumbers(int number, int* seen) {
    while (number > 0) {


        int remainder = number % 10;

        if (seen[remainder] == 1) {
            break;
        }

        seen[remainder] = 1;
        number = number / 10;

    }

    if (number > 0) {

        printf("Yes, there is repetition\n");
    }

    else {
        printf("No, there is not repetition\n");
    }
}