#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
int main() {
    pid_t pid;

    char command[64];

    printf("$ ");
    scanf("%s", command);

    while(strcmp(command, "exit")) {
        pid = fork();

        if (pid == 0) {
            execlp(command, command, NULL);
            printf("Invalid command\n");
            exit(0);
        }

        else if (pid > 0) {

            waitpid(pid, 0, 0);
            memset(command, '\0', 64);
            printf("$ ");
            scanf("%s", command);
        }

        else {
            perror("EROR FORK\n");
        }
    }
    
    exit(0);
}

              
