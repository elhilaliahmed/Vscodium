#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
int main(int argc, char*argv[]) {
    int id = fork();
    if (id == 0) {
        sleep(1);
    }
    printf("Current ID: %d, parent ID: %d\n", getpid(), getppid());
    
/*  
    if (id != 0) {
        wait(NULL);
    }
*/

    int res = wait(NULL);

    if(res == -1) {
        printf("No children to wait for\n");
    }
    else {
        printf("%d finished execution\n", res);
    }

/*
    if(wait(NULL) == -1) {
        printf("No children to wait for\n");
    }
*/
    return 0;
}