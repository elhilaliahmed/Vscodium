#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void* b) {

    int *x = (int*)a;
    int *y = (int*)b;
    return *x - *y;
    
    // the previous three line can be done in a single line
    // We first can't the void* pointer to an int* pointer and then derefenrence then
    //return (*(int*)a - *(int*)b);
}
int main(int argc, char **argv) {


    int nums[(argc - 1)];

    for (int i = 0; i < (argc - 1); i++) {
        nums[i] = atoi(argv[(i + 1)]);
    }

    qsort(nums, (argc - 1), sizeof (int), cmp);

    for (int i = 0; i < (argc - 1); i++) {
        printf("%d, ", nums[i]);
    }
    printf("\n");

    return 0;
}