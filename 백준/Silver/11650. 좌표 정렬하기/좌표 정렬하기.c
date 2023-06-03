#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct __coordinate{
    int x, y;
}Coordinate;

Coordinate sort[100000];

void merge(Coordinate *coordinate, int p, int q, int r){
    int i = p;
    int j = q + 1;
    int k = p;

    while(i<=q && j <= r){
        if(coordinate[i].x < coordinate[j].x)
            sort[k++] = coordinate[i++];
        else if(coordinate[i].x == coordinate[j].x){
            if(coordinate[i].y < coordinate[j].y)
                sort[k++] = coordinate[i++];
            else
                sort[k++] = coordinate[j++];
        }
        else
            sort[k++] = coordinate[j++];
    }
    if(i > q){
        while(j <= r)
            sort[k++] = coordinate[j++];
    } else{
        while(i <= q)
            sort[k++] = coordinate[i++];
    }
    for(k=p; k<=r; k++)
        coordinate[k] = sort[k];
}

void mergeSort(Coordinate *coordinate, int p, int r){
    int q;
    if(p < r){
        q = (p + r) / 2;
        mergeSort(coordinate, p, q);
        mergeSort(coordinate, q+1, r);
        merge(coordinate, p, q, r);
    }
}

int main()
{
    int N;
    scanf("%d", &N);

    Coordinate c[100000];

    for(int i=0; i<N; i++)
        scanf("%d%d", &c[i].x, &c[i].y);
    
    mergeSort(c, 0, N-1);

    for(int i=0; i<N; i++){
        printf("%d %d\n", c[i].x, c[i].y);
    }

    return 0;
}