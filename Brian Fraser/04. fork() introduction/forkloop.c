#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(int argc, char **argv) {
    for (int i = 1; i <= 4; i++) {
        // I will get 4 processes on the second pass
        fork();
        printf("%d: my pid = %d\n", i, (int)getpid());
    }

    sleep(2);
    printf("-> pid = %d\n", (int)getpid());

    // This is dangerous, it's a fork() bomb
    while(1) {
        fork();
    }
    return 0;
}

