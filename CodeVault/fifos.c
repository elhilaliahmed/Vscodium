#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <errno.h>
#include <fcntl.h>

int main(int argc, char* argv[]) {

    if (mkfifo("myfifo", 0777) == -1) {
        if (errno != EEXIST) {
            printf("Could not creat fifo\n");
            return 1;
        }
    }

    printf("Opening...\n");  

    int fd = open("myfifo", O_RDWR);

    if (fd == -1) {
        return 3;
    }

    printf("Opened...\n");

    int x = 'Z';
    if (write(fd, &x, sizeof(int)) == -1) {
        printf("Something bad happened");
        return 2;
    }

    printf("Written...\n");
    close(fd);
    printf("Closed...\n");

    return 0;
}