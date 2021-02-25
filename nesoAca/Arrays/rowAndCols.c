#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char* argv[]) {

    int nums[5][5] = {8, 3, 9, 0, 10, 3, 
                      5, 17, 1, 1, 2, 
                      8, 6, 23, 1, 15, 
                      7, 3, 2, 9, 6, 
                      14, 2, 6, 0};
    int rowSum = 0;
    int colSum = 0;

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            printf("%d ", nums[i][j]);

        }
        printf("\n");
    }
    printf("\n");

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            rowSum += nums[i][j];
        }
        printf("Rows %d: %d \n", (i + 1) , rowSum);
        rowSum = 0;
    }

    printf("\n");

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            colSum += nums[j][i];
        }
        printf("Cols %d: %d\n", (i + 1), colSum);
        colSum = 0;
    }

    return 0;
}




