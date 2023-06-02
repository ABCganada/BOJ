#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char str[20000][51];
char output[20000][51];

void merge(char str[][51], int first, int mid, int last){
    int i = first;
    int j = mid + 1;
    int k = first;

    while(i<=mid && j <= last){
        if(strlen(str[i]) < strlen(str[j])){
            strcpy(output[k++], str[i++]);
        } else if(strlen(str[i]) > strlen(str[j])){
            strcpy(output[k++], str[j++]);
        } else{
            if(strcmp(str[i], str[j]) < 0){
                strcpy(output[k++], str[i++]);
            } else{
                strcpy(output[k++], str[j++]);
            }
        }
    }
    if(i > mid){
        while(j <= last)
            strcpy(output[k++], str[j++]);
    } else{
        while(i <= mid)
            strcpy(output[k++], str[i++]);
    }
    for(k=first; k<=last; k++)
        strcpy(str[k], output[k]);
}

void mergeSort(char str[][51], int first, int last){
    int mid;
    if(first < last){
        mid = (first + last) / 2;
        mergeSort(str, first, mid);
        mergeSort(str, mid+1, last);
        merge(str, first, mid, last);
    }
}

int main()
{
    int N;
    scanf("%d", &N);
    getchar();

    for(int i=0; i<N; i++)
        scanf("%s", str[i]);
    
    mergeSort(str, 0, N-1);

    printf("%s\n", str[0]);
    for(int i=1; i<N; i++){
        if(strcmp(str[i-1], str[i]) != 0)
            printf("%s\n", str[i]);
    }

    return 0;
}