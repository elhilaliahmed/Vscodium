#include <stdio.h>

/**
 * @brief This function calculate the minimum and maximum numbers in an array
 * 
 * @param arr the array
 * @param len the length of the array
 * @param min the minimux value in the array
 * @param max the maximum value in the array
 */
void minMax(int arr[], int len, int *min, int *max);

int main(int argc, char* argv[]) {


    int a[] = {23, 45, 6, 98, 54, 564, -1, 4, 74, 32};
    int min, max;
    int len = sizeof(a) / sizeof(a[0]);

    minMax(a, len, &min, &max);

    printf("Minimum value: %d\nMaximum value: %d\n", min, max);

    return 0;
}

void minMax(int arr[], int len, int* min, int* max) {

    *min = *max = *arr;

    for (int i = 1; i < len; i++) {

        if (arr[i] > *max) {
            *max = *(arr + i);
        }

        if (arr[i] < *min) {
            *min = *(arr + i);
        }
    }
}