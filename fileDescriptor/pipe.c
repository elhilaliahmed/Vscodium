#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (int argc, char *argv[]) {
    
    pid_t pid;    
    int mypipefd[2];
    char buf[20];

    int ret = pipe(mypipefd);

    if(ret == -1) {
        perror("pipe");
        exit(1);
    }

    pid = fork();

    if (pid == 0) {
        // child process
        printf("Child process\n");
        close(mypipefd[0]);
        write(mypipefd[1], "rereer there!", 12);
    }
    
    else {
        // parent process
        printf("Parent process\n");
        close(mypipefd[1]);
        read(mypipefd[0], buf, 15);
        printf("buf: %s\n", buf);
    }
}