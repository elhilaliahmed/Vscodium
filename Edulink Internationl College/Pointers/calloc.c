#include <stdio.h>
#include <stdlib.h>

int main() {
    float *calloc1, *calloc2;
    calloc1 = (float*) calloc(3, sizeof(float));
    calloc2 = (float*) calloc(3, sizeof(float));

    if (calloc1 != NULL && calloc2 != NULL) {
        for (int i = 0; i < 3; i++) {
            printf("\ncalloc1[%d] holds %.5f ", i, calloc1[i]);
            printf("\ncalloc2[%d] holds %.5f ", i, calloc2[i]);
        }
        free(calloc1);
        free(calloc2);
        return 0;
    }

    printf("Not able to allocate, not enough memory\n");
    return 1;
}