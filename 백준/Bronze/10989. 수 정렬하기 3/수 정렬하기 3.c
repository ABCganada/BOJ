#include <stdio.h>
#include <stdlib.h>

#define MAX 10001

int main()
{
    int CountArr[MAX] = {0,};
    int n, i, tmp;
    scanf("%d", &n);
    //카운팅 배열 입력
    for(i=0; i<n; i++){
        scanf("%d", &tmp);
        CountArr[tmp]++;
    }

    for(i=0; i<MAX; i++){
        if(CountArr[i] != 0){
            for(int j=0; j<CountArr[i]; j++)
                printf("%d\n", i);
        }
    }


    return 0;
}