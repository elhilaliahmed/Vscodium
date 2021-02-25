/* getpid: print a process' process ID */
/* Paul Krzyzanowski */

#include <stdlib.h>	/* needed to define exit() */
#include <unistd.h>	/* needed to define getpid() */
#include <stdio.h>	/* needed for printf() */

int
main(int argc, char **argv) {

	printf("my process ID is:\t\t %d\n", getpid());
    printf("my parent's process Id is:\t %d\n", getppid());


	exit(0);
}
