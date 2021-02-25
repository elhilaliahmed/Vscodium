#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() {

    fork();
    fork();
    fork();
    printf("PID = %d\n", getpid());
    printf("Ahmed\n");
    return 0;
}