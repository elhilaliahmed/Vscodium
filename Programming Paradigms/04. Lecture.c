#include <stdio.h>

void *lsearch1(void *key, void *base, int n, int elemSize) {
    for (int i = 0; i < n; i++) {
        void *elemAddr = (char*)base + i*elemSize;
        if (memcmp(key, elemAddr, elemSize) == 0) {
            return elemAddr;
        }
    }
    return NULL;
}

void *lsearch(void *key, void *base, int n, int elemSize, int (*cmpfun)(void*, void*)) {

    for (int i = 0; i < n; i++) {
        void *elemAddr = (char*)base + i*elemSize;
        if (cmpfun(key, elemAddr) == 0) {
            return elemAddr;
        }
    }
    return NULL;
}

int intCmp(void* elem1, void* elem2) {
    int *ip1 = (int*) elem1; // can also be done without casting
    int *ip2 = (int*) elem2; // can also be done without casting
    return *ip1 - *ip2;
}


int noteCmp(void* elem1, void* elem2) {
    char *s1 = *(char**) elem1;
    char *s2 = *(char**) elem2;
    return (strncmp(s1, s2));
}

int main() {
    int array[] = {4, 2, 3, 7, 11, 6};
    int size = 6;

    int number = 7;
    int* found = lsearch(&number, array, 6, sizeof(int), intCmp);
    // if (found == NULL) => element doesn't exist;
    // else element exists

    char *note[] = {"Ab", "F#", "B", "Gb", "D"};
    char *favNote = "Eb";

    char **found = lsearch(&favNote, note, 5, sizeof(char*), noteCmp);
}

void *bsearch(void *key, void *base, int n, int elemSize, int (*cmp) (void*, void*));

// stack.h 
typedef struct {
    int *elems;
    int logicalLength;
    int allocLength;
} stack;

void stackNew(stack *s); 
void stackDispose(stack *s);
void stackPush(stack *s, int value);
int stacPop(stack *s);

void stackNew(stack *s) {
    s -> logicalLength = 0;
    s -> allocLength = 4;
    s -> elems = malloc(4 * sizeof(int));
    assert(s -> elems != NULL);
}





