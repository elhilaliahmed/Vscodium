- Finding maximum number:
```c
#include <stdio.h>
main() {
    int n, max, number;
    scanf("%d", &n);
    if (n > 0) {
        scanf("%d", & number);
        max = number;
        for (int i = 1; i <= n; i++) {
            scanf("%d", &number);
            if (number > max) max = number;
        }
        printf("MAX = %d \n", max)
    }
}
```
- Sorting:

```c
#include <stdio.h>
main() {
    int data[100], n, temp;
    scanf("%d", &n);
    for (i = 0; i < n; i++)
        scanf("%d", &data[i]);
    
    for(i = 0; i < n - 1; i++)
        for(j = i + 1; j < n; j++)
            if (data[i] > data[j]) {

                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
    for(i = 0; i < n; i++) 
        printf("%d ", data[i]);
    printf("\n");
}
```
- Matrix multiplication:

```c
#include <stdio.h>
main() {
    int a[10][10], b[10][10], c[10][10];
    int i, j, k, m, n, o;

    /* Reading the data */
    scanf("%d %d %d", &m, &n, &o);
    for (i = 1; i <= m; i++)
        for (j = 1; j <= n; j++)
            scanf("%d", &a[i][j]);
    
    for(i = 1; i <= n; i++)
        for (j = 1; j <= o; j++)
            scanf("%d", &b[i][j]);

    /* Performing the multiplication */
    for (i = 1; i <= m; i++)
        for (j = 1; j <= o; j++) {
            c[i][j] = 0;
            for (k = 1; k <= n; k++)
                c[i][j] = c[i][j] + a[i][k] * b[k][j];
        } 
    
    /* Printing the result */
    for (i = 1; i <= m; i++)
        for (j = 1; j <= o; j++)
            printf("%d ", c[i][j]);
        printf("\n");
}
```
