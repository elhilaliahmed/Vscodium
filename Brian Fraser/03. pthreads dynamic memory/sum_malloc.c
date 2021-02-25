#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void* sum_runner (void* arg) {
    
    long long *limit_ptr = (long long*) arg;
    long long limit = *limit_ptr;
    
    // I can use arg and then clear it
    free(arg);

    // pass back data in dynamically allocated memory
    long long* answer = malloc(sizeof(*answer));
    *answer = (limit/2) * (limit + 1);

    // we can pass it a pointer
    pthread_exit(answer);

}

int main (int argc, char** argv) {
    if (argc < 2) {
        printf("You should enter the numbers that you want to computer, enter more than just the name of the program as an argument");
        exit(-1);
    }

    long long* limit = malloc(sizeof(*limit));
    // using asci to long long
    *limit = atoll(argv[1]);
    //long long limit = atoll(argv[1]);

    // thread id:
    pthread_t tid;

    // create attribute:
    pthread_attr_t attr;
    
    // initialize attribute:
    pthread_attr_init(&attr);

    // create the thread using the id, the attribute, the function and the arg
    pthread_create(&tid, &attr, sum_runner, limit);

    // Here we can do other stuff if needed

    // wait until the thread is done its work
    long long* result; 
    pthread_join(tid, (void**)&result);

    // printing the result of the calculated sum to the screen
    printf("Sum is: %lld", *result);

    free(result);
}