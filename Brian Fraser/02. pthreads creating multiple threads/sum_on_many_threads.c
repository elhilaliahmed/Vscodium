#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
// The sum computed by the background thread must be global, so that the main function can access it

struct sum_runner_args {
    long long limit;
    long long answer;
};

void* sum_runner (void* arg) {
    // Type casting a void* into a pointer to my structure
    struct sum_runner_args *arg_struct = (struct sum_runner_args *) arg;

    // dereferencing a pointer to get the value stored at that memory address
    long long limit = arg_struct -> limit;
    
    long long sum = 0;

    for (long long i = 0; i <= limit; i++) {
        sum += i;
    }
    // putting the result in answer in my struct

    arg_struct -> answer = sum;


    /*
        it can also be done without a for loop
        long long limit = arg_struct -> limit;
        arg_struct -> answer = (limit/2) * (limit + 1);
    */

    pthread_exit(0);

}

int main (int argc, char** argv) {
    if (argc < 2) {
        printf("You should enter the numbers that you want to computer, enter more than just the name of the program as an argument");
        exit(-1);
    }

    // calculating the number of thread we want to spawn, the number of calculation we want to do
    int num_args = argc - 1;

    // convert a string to an integer using the function atoi

    // creating thread id
    pthread_t tids[num_args];

    // build me an array of num_args
    struct sum_runner_args args[num_args];
    
    for (int i = 0; i < num_args; i++) {

        args[i].limit = atoi(argv[i + 1]);

        pthread_attr_t attr;
        pthread_attr_init(&attr);
        pthread_create((tids + i), &attr, sum_runner, (args + i));
        //pthread_create(&tids[i], &attr, sum_runner, &args[i]);  is equivalent to the previous line

    }

    // after the pthread create and the pthread_join I can do a fair amount of work, I can do other stuff here.
    // I could spawn other thread, do some computation or interact with the user...join

    // wait until all the thread finish
    for (int i = 0; i < num_args; i++) {
        pthread_join(tids[i], NULL);
    }

    // if the sum wasn't global, we will not be able to print it here:
    for (int i = 0; i < num_args; i++) {
        printf("Sum of number from 0 to %lld is:\t %lld\n",args[i].limit, args[i].answer);
    }
}