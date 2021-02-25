#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void doSomeWork(char* name) {
    
    const int NUM_TIMES = 4;
    for (int i = 0; i < NUM_TIMES; i++) {
        // sleep a random amount of time
        // sleep between zero and three seconds
        sleep(rand() % 4);
        printf("%d pass is finished for %s\n", i, name);
    }
}

int main(int argc, char *argv[]) {

    printf("I am: %d \n", (int) getpid());

    pid_t pid = fork();

    // making it more random, so that each process sleeps a different amount of time
    srand(pid);
    printf("fork returned: %d \n", pid);


    if (pid < 0) {
        perror("fork failed");
    }

    if (pid == 0) {
        
        printf("I'm the child with pid: %d\n", (int) getpid()); // I can't use the pid from fork, because it will tell me it's 0
        doSomeWork("Child");
        exit(42);
    }


    // After handling the error and the child, I'm certain that I'm the parent, we can make the parent do whatever he needs to do

    
    printf("I'm the parent waiting for child to terminate...\n");
    sleep(15);

    // I'll make the parent execute the same code as well

    //doSomeWork("Parent");
    // wait until the child process terminate
    
    int status = 0;

    // since wait expected an integer to a pointer, then we can give it the address of our integer status
    pid_t childpid = wait(&status);

    // the (int) casting is not necessary, because pid_t is just a typedef for int
    printf("Parent knows that child %d is finished with status %d\n", (int)childpid, status);

    // we can use macros to know more about the return value

    int childReturnValue = WEXITSTATUS(status);
    printf("Return value was %d\n", childReturnValue);
    sleep(30);
    
    return 0;
}