#include <stdio.h>
typedef struct {
    void *elems;
    int elemSize;
    int logicalLength;
    int allocLenth;
    void (*freeFun) (void*);
} stack;

void stackNew(stack *s, int elemSize, void (*freeFun)(void*)) {

}

void stackDispose(stack *s) {
    if (s -> freeFun != NULL) {
        for (int i = 0; i < s -> logicalLength; i++) {
            s -> freeFun ((char*) s -> elems + i * s -> elemSize);
        }
    }
    free(s -> elems);
}

void stringFree(void *elem) {
    free(*(char**)elem);
}

int main (int argc, char* argv[]) {
    const char *friends[] = {"Al", "Bob", "Carl"};
    stack stringStack;
    stackNew(&stringStack, sizeof(char*), stringFree);
    for (int i = 0; i < 3; i++) {
        char *copy = strdup(friends[i]);
        stackPush(&stringStack, &copy);
    }

    char *name;
    for (int i = 0; i < 3; i++) {
        stackPop(&stringStack, &name);
        printf("%s", name);
        free(name);
    }
    stackDispose(&stringStack);
}

void rotate(void *front, void *middle, void *end) {
    int frontSize = (char*)middle - (char*)front;
    int backSize = (char*)end - (char*)middle;
    char buffer[frontSize];
    memcpy(buffer, front, frontSize);
    memmove(front, middle, backSize);
    memcpy((char*) end - frontSize, buffer, frontSize);
}   

/*
man qsort
man bsearch
man memcpy
man memmove
man malloc
man realloc
man free
*/
