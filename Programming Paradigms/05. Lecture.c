#include <stdio.h>
// stack.h 
typedef struct {
    int *elems;
    int logicalLength;
    int allocLength;
} stack;

void stackNew(stack *s); 
void stackDispose(stack *s);
void stackPush(stack *s, int value);
int stackPop(stack *s);

void stackNew(stack *s) {
    s -> logicalLength = 0;
    s -> allocLength = 4;
    s -> elems = malloc(4 * sizeof(int));
    assert(s -> elems != NULL);
}

void stackDispose(stack *s) {
    free(s -> elems);
}

void stackPush(stack *s, int value) {
    if (s -> logicalLength == s -> allocLength) {
        s -> allocLength *= 2;
        s -> elems = realloc(s -> elems, s -> allocLength * sizeof(int));
        assert(s -> elems != NULL);
    }
    s -> elems[ s -> logicalLength] = value;
    s -> logicalLength++;  
}

int stackPop(stack *s) {
        assert(s -> logicalLength > 0);
        s -> logicalLength--;
        return (s -> elems[s -> logicalLength]);
}