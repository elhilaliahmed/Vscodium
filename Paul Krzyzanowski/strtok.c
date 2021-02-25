/* strtok example */
/* Paul Krzyzanowski */

#include <stdio.h>
#include <string.h>	/* needed for strtok */

int
main(int argc, char **argv) {
	char text[] = "ls -F -l -   l";
	char *t;
	int i;

	t = strtok(text, " ");
	for (i=0; t != NULL; i++) {
		printf("token %d is \"%s\"\n", i, t);
		t = strtok(NULL, " ");
	}
}