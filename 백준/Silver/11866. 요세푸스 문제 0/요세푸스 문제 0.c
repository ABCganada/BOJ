#include <stdio.h>

int main()
{
    int i, N, K, cnt;
    scanf("%d %d", &N, &K);
    int arr[N];
    int ans[N], idx = 0;

    for(i=0; i<N; i++){
        arr[i] = i+1;
    }

    int j=-1;
    for(i=0; i<N; i++){
        cnt = 0;
        while(cnt < K){
            j++;
            if(j >= N) 
                j = j%N;
            if(arr[j] != 0)
                cnt++;
        }
        ans[idx++] = arr[j];
        arr[j] = 0;
    }
    printf("<%d", ans[0]);
    for(i=1; i<N; i++)
        printf(", %d", ans[i]);
    printf(">\n");

    return 0;
}