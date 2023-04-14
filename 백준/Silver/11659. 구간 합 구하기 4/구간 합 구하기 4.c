// 11659
#include <stdio.h>
#include <stdlib.h>

#define MAX_N 100000
#define MAX_M 100000

int main()
{
    int n, m, i, pos1, pos2;
    int *arr = NULL;
    int *prefixSum = NULL;

    scanf("%d %d", &n, &m);

    arr = (int *)malloc(sizeof(int) * n);
    prefixSum = (int *)malloc(sizeof(int) * n);
    for(i=0; i<n; i++){
        scanf("%d", &arr[i]);
        if(i==0)
            prefixSum[i] = arr[i];
        else
            prefixSum[i] = prefixSum[i-1] + arr[i];
    }
    

    for(i=0; i<m; i++){
        int sum = 0;
        scanf("%d%d", &pos1, &pos2);
        if(pos1 == 1){
            printf("%d\n", prefixSum[pos2-1]);
            continue;
        }
        printf("%d\n", prefixSum[pos2-1] - prefixSum[pos1-2]);
    }

    free(arr);
    free(prefixSum);


    return 0;
}
