#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <errno.h>


int main(int argc, char* argv[]) {

    int fd[2];

    // fd[0] - read
    // fd[1] - write

    if (pipe(fd) == -1) {
        printf("An error ocurred with opening the pipe\n");
        return 1;
    }

    int id = fork();

    if (id == 0) {
        close(fd[0]):
        int x;
        printf("Enter an number: ");
        scanf("%d", &x);
        write(fd[1], &x, sizeof(int));
        close(fd[1]);
    } else {
        close(fd[1]);
        int y;
        read(fd[0], &y, sizeof(int));
        close(fd[0]);

        printf("Got from child proces %d")
    }







    return 0;
}










/*
int main(int argc, char* argv[]) {

    int id1 = fork();
    int id2 = fork();

    if (id1 == 0) {
        if (id2 == 0) {
            printf("We are process y\n");
        }
        else {
            printf("We are process x\n");
        }
    }
    else {
        if (id2 == 0) {
            printf("We are process z\n");
        }
        else {
            printf("We are the parent process\n");
        }
    }


    while(wait(NULL) != -1 || errno != ECHILD) {
        printf("Waited for a child to finish\n");
    }

    return 0;
}
*/