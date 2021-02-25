#include <stdio.h>
#include <malloc.h>

int main() {
    int *p, tmp, n;
    printf("\nEnter number of elements in the array: ");
    scanf("%d",&n);

    p = (int*)malloc(n * sizeof(*p));

    for (int i = 0; i < n; i++) {
        printf("\nEnter element no. %d: ", (i + 1));
        scanf("%d", p + i);
    }

    for (int i = 0; i < (n - 1); i++) {
        for (int j = (i + 1); j < n; j++) {
            if (*(p + i) > *(p + j)) {
                tmp = *(p + i);
                *(p + i) = *(p + j);
                *(p + j) = tmp;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        printf("%d\n", *(p + i));
    }
}