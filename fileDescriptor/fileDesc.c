#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main() {
    
    int fileDescriptor, standardError;
    int ret;

    fileDescriptor = open("out.txt", O_CREAT | O_APPEND | O_WRONLY);

    if(fileDescriptor < 0) {
        perror("open");
        exit(1);
    }

    standardError = open("error.txt", O_CREAT | O_APPEND | O_WRONLY);

    ret = dup2(fileDescriptor, 1);
    if (ret < 0) {
        perror("dup2 output");
        exit(1);
    }

    ret = dup2(standardError, 2);
    if (ret < 0) {
        perror("dup2 error");
        exit(1);
    }

    system("ls /tmp");
    close(fileDescriptor);
    close(standardError);

    return 0;
}