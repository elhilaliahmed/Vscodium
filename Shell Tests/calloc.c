#include <stdio.h>
#include <stdlib.h>
int main() {

    int n, *numbers;
    
    printf("Enter size: ");
    scanf("%d", &n);

    numbers = (int*)calloc(n, sizeof(int));
    
    if(numbers == NULL) {
        printf("Memory was not allowated\n");
    }

    else {
        printf("Array elements are\n");
        for(int i = 0; i < n; i++) {
            printf("%d ", *(numbers + i));
        }
    }




    return 0;
}