#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <errno.h>

int main(int argc, char* argv[]) {
    int numbers[] = {1, 2, 3, 4, 1, 2};
    int length = sizeof(numbers) / sizeof(int);
    int fd[2];
    int start, end;

    if (pipe(fd) == -1) {
        return 1;
    }
    
    int id = fork();
    if (id == -1) {
        return 2;
    }

    if (id == 0) {
        start = 0;
        end = length / 2;
    }

    else {
        start = length / 2;
        end = length;
    }

    int sum = 0;

    for (int i = start; i < end; i++) {
        sum += numbers[i];
    }

    printf("Calculated partial sum: %d\n", sum);

    if (id == 0) {

        if (write (fd[1], &sum, sizeof(sum)) == -1) {
            return 4; // to signal that something went wrong
        }
        close(fd[1]);
    }

    else {
        int sumFromChild;
        close (fd[1]);
        if (read(fd[0], &sumFromChild, sizeof(sumFromChild)) == -1) {
            return 4; // to signql thqt something went wrong
        }
        close(fd[0]);
        int total = sum + sumFromChild;
        printf("Total sum is %d\n", total);
        wait(NULL);
    }
    
    return 0;
}