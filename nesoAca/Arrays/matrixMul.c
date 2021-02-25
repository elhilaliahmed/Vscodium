#include <stdlib.h>
#include <stdio.h>
#define MAX 50

int main(int argc, char *argv[])
{
    int a[MAX][MAX], b[MAX][MAX], product[MAX][MAX];
    int arows, acolums, brows, bcolums;
    int sum = 0;

    printf("Enter the rows and colums of the matrix a: \n");
    scanf("%d %d", &arows, &acolums);
    
    printf("Enter the elements of matrix a: \n");
    for (int i = 0; i < arows; i++) {
        for (int j = 0; j < acolums; j++) {
            scanf("%d", &a[i][j]);
        }
    }

    printf("Enter the rows and colums of the matrix b: \n");
    scanf("%d %d", &brows, &bcolums);

    if (brows != acolums) {
        printf("Sorry, matrices multiplication is not possible, the number colums of the first matrix must\
                be equal to the number of rows of the second matrix\n");
    }
    else {
        printf("Enter the elements of matrix b: \n");
        for (int i = 0; i < brows; i++) {
            for (int j = 0; j < bcolums; j++) {
                scanf("%d", &b[i][j]);
            }
        }
    }

    printf("\n");

    for (int i = 0; i < arows; i++) {
        for (int j = 0; j < bcolums; j++) {
            for (int k = 0; k < brows; k++) {
                sum += a[i][k] * b[k][j];
            }
            product[i][j] = sum;
            sum = 0;
        }
    }

    printf("Resultant matrix\n");

    for (int i = 0; i < arows; i++) {
        for (int j = 0; j < bcolums; j++) {
            printf("%.2d ", product[i][j]);
        }
        printf("\n");
    }

    return 0;
}