#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM_CHILDREN 10
int main(int argc, char** argv) {

    for (int i = 0; i < NUM_CHILDREN; i++) {
        pid_t pid = fork();

        if (pid < 0) {
            perror("fork failed");
            exit(1);
        }

        if (pid == 0) {
            // Child now exec's
            char* args[] = {"./sort", "10", "-1", "50", "5", "4","2","1","3", NULL};

            execv(args[0], args);

            printf("Never going to see this!\n"); // This code will never be reached
        }
    }
    // Parent
    // Do clever processing here
    printf("Parent is doing something amazing here...\n");
    // Parent wait for child

    printf("Parent is waiting on child process\n");
    for (int i = 0; i < NUM_CHILDREN; i++) {
        wait(NULL);
    }

    return 0;
}