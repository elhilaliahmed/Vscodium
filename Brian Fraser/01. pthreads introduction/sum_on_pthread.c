#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
// The sum computed by the background thread must be global, so that the main function can access it
// 
long long sum = 0;

void* sum_runner (void* arg) {
    // Type casting a void* to a long long*
    long long *limit_ptr = (long long*) arg;

    // dereferencing a pointer to get the value stored at that memory address
    long long limit = *limit_ptr;

    for (long long i = 0; i <= limit; i++) {
        sum += i;
    }

    // What to do with the anwser???
    // I have the anwser and I will display it using the main function, check the main function below
    // Sum is a global variable so other thread can access it

    // exiting the thread without returning anything
    // The value usually get passed to pthread_join(tid, NULL), but since it's NULL, then it's not expecting anything, so it will not catch the anwser
    pthread_exit(0);

}

int main (int argc, char** argv) {
    if (argc < 2) {
        printf("You should enter the number that you want to computer, enter more than just the name of the program as an argument");
        exit(-1);
    }

    // convert a string to an integer using the function atoi
    long long limit = atoi(argv[1]);

    // creating thread id
    pthread_t tid;

    // create attribute
    pthread_attr_t attr;
    pthread_attr_init(&attr);

    pthread_create(&tid, &attr, sum_runner, &limit);

    // after the pthread create and the pthread_join I can do a fair amount of work, I can do other stuff here.
    // I could spawn other thread, do some computation or interact with the user...join

    // wait until thread is done its work
    pthread_join(tid, NULL);

    // if the sum wasn't global, we will not be able to print it here:
    printf("Sum is: %lld", sum);
}