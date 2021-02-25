#include <stdio.h>

char* stringReverse(char*);

int main() {
    char* string = "Ahmed";
    printf("\n %s", stringReverse(string));

    return 0;
}

char* stringReverse(char* string) {
    static char output[50];
    char* in = string;
    char* out = output;
    
    while(*in != '\0') {
        in++;
    }

    in--;
    while(in >= string) {
        *out = *in;
        in--;
        out++;
    }

    return output;
}
