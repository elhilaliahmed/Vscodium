#include <stdio.h>
#include <stdlib.h>

/*
* sort integer array in the ascending order by using qsort
*/

int compare(const void* n1, const void* n2) {
    int i1 = *(int*)n1;
    int i2 = *(int*)n2;
    return i2 - i1;
}


int main() {

    int arr[5] = {1,8,2,3,4};
    
    printf("initial array: ");
    for(int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }

    printf("\narray after soring: ");
    qsort(arr, sizeof(arr) / sizeof(int), sizeof(int), compare);
    for(int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }

    return 0;   
}