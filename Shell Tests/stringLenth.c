#include <stdio.h>

int stringlength(char*);

int main() {
    char* text = "Ahmed elhilali";
    printf("Lenth = %d characters", stringlength(text));

    return 0;
}

int stringlength(char* string) {
    int length = 0;
    while(*string++ != '\0') {
        length++;
    }
    return length;
}