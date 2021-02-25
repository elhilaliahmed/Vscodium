#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
int main(int agrc, char* agrv[]) {
    int pid, cid;
    
    pid = getpid();
    printf("Fork demo! I'm the parent (pid = %d)\n", pid);

    if (!fork()) {
        cid = getpid();
        printf("I'm the child (cid = %d) of (pid = %d)\n", cid, pid);
        childProcess();
        exit(0);
    }

    printf("Parent waiting here for the child...\n");
    wait(NULL);
    printf("Child finished, parent quitting too!\n");

    return 0;

}

void childProcess() {
    for (int i = 0; i < 5; i++) {
        printf("%d...\n", i);
        sleep(2);
    }
}