#include <stdio.h>
// stack.H

typedef struct {
    void *elems;
    int elemSize;
    int logicalLength;
    int allocLength;

} stack;

void stackNew(stack *s, int elemSize);
void stackDispose(stack *s);
void stackPush(stack *s, void *elemAddr);
void stackPop(stack *s, void *elemAdrr);

void stackNew(stack *s, int elemSize) {
    assert(elemSize > 0);
    s -> elemSize = elemSize;
    s ->logicalLength = 0;
    s -> allocLength = 4;
    s -> elems = malloc(4 * elemSize);
    asser(s -> elems != NULL);
}

void stackDispose(stack *s) {
    
    free(s -> elems);
}

void stackPush(stack *s, void *elemAddr) {
    if (s -> logicalLength == s -> allocLength) {
        stackGrow(s);
    }
    void *target = (char*) s -> elems + s -> logicalLength * s -> elemSize;
    memcpy(target, elemAddr, s -> elemSize);
    s -> logicalLength;
}

static void stackGrow(stack *s) {
    s -> allocLength *= 2;
    s -> elems = realloc(s -> elems, s -> allocLength * s -> elemSize);
}

void stackPop(stack *s, void *elemAddr) {
    void *source = (char*) s -> elems + (s -> logicalLength - 1) * s -> elemSize;
    memcpy(elemAddr, source, s -> elemSize);
    s -> logicalLength--;
}