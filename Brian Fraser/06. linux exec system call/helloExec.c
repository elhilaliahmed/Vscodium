#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
int favNum = 100;
int main(int argc, char **argv) {
    printf("helloExec.c: favNum is %d\n", favNum);
    printf("        My PID is %d\n", getpid());
    printf("        My arguments: ");
    for (int i = 0; i < argc; i++) {
        printf("%s, ",argv[i]);
    }

    printf("\n");

    return 0;
}
