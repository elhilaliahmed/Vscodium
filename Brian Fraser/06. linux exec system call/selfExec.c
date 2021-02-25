#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// This gets completly wipped out after the exec
int height = 51;

int main(int argc, char **argv) {
    
    printf("selfExec: My pid is %d\n", getppid());
    printf("Height is: %d\n", height);
    height--;

    if (argc != 2) {
        printf("Pass 1 argument as an integer\n");
        exit(1);
    }

    int n = atoi(argv[1]);
    printf("%d...\n", n); // we can use fflush() instread of a newline

    if (n != 0) {
        char nMinus1[10];
        sprintf(nMinus1, "%d", n - 1);
        execl(argv[0], argv[0], nMinus1, NULL);
    }

    // This code will never be reached, because execvp never return unless if there's an error
    // Everything gets replaced with the new program we try to execute, in this case "./helloExec"
    printf("Farewell cruel world!\n");
    return 0;
}