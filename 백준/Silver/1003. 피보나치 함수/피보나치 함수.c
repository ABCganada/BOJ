#include <stdio.h>

int main()
{
    int arr0[41], arr1[41];
    int T, N;
    scanf("%d", &T);

    arr0[0] = 1;
    arr0[1] = 0;
    arr1[0] = 0;
    arr1[1] = 1;

    for(int i=2; i<41; i++){
        arr0[i] = arr0[i-1] + arr0[i-2];
        arr1[i] = arr1[i-1] + arr1[i-2];
    }

    for(int i=0; i<T; i++){
        scanf("%d", &N);
        printf("%d %d\n", arr0[N], arr1[N]);
    }



    return 0;
}