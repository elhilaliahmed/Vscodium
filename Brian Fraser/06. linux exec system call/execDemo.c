#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// This gets completly wipped out after the exec
int favNum = 50;
int main(int argc, char **argv) {
    
    printf("execDemo: My pid is %d\n", getppid());
    char *args[] = {"./helloExec", "hello", "world", NULL};
    execvp(args[0], args);

    // This code will never be reached, because execvp never return unless if there's an error
    // Everything gets replaced with the new program we try to execute, in this case "./helloExec"
    printf("Farewell cruel world!\n");
    return 0;
}