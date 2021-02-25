#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

void foo() {
    int arr[4];
    int i;
    for (i = 0; i <= 4; i++) {
        arr[i] -= 4;

    }
    printf("Done in foo()");
}
//int strlen(char* s, int len);
int main(int argc, char* argv[]) {

    foo();

    printf("Done in main!");

    /* int num = 65;
    int length = strlen((char*)&num, num);
    printf("Length = %d\n", length);
    return 0;*/
}

    /*
    void* mem = malloc(4000000000);
    assert(mem != NULL);
    printf("Yay!");
    free(mem);
    int num = 50;
    int nums[] = {1, 2, 3};
    nums[-1] = 100;
    printf("%d\n", num);
    return 0;

    */