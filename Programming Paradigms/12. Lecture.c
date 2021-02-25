#include <stdio.h> // printf
#include <stdlib.h> // malloc, free
#include <assert.h>

#define MAX(a,b) (((a) > (b)) ? (a) : (b))

/*
MAX(10, "Hello") compiles without problems


gcc -c vectorc.c to check -E 



*/

int main(int argc, char *argv[]) {
    
    void * memory = malloc(400);
    assert(memory != NULL);
    printf("Yay!");
    free(memory);

    return 0;
}

/* The previous code fed to gcc 

gcc -c stop at compilation and doesn't build  and executable
by default it produces an executable file called a.out
using -o can let us specify a name.





*/