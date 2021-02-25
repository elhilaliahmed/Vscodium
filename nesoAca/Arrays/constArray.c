#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[]) {


    printf("Enter the number of elements you want to reverse: \n");
    int n;
    scanf("%d", &n);
    static int a[n];

    int i;

    printf("Enter all the %d elements: \n", n);

    for (i = 0; i < n; i++) {
        scanf("%d ", &a[i]);
    }

    printf("Elements in reverse order are: \n");

    for (i = n - 1; i >= 0; i--) {
        printf("%d ", a[i]);
    }




    return 0;
}