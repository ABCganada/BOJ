#include <stdio.h>

void towerOfHanoi(int N, char from, char aux, char to);

int main()
{
    int n, move = 1;
    scanf("%d", &n);
    for(int i=0; i<n; i++)
        move *= 2;
    move--;
    printf("%d\n", move);
    towerOfHanoi(n, '1', '2', '3');

    return 0;
}
void towerOfHanoi(int N, char from, char aux, char to){
    if(N==1){
        printf("%c %c\n", from, to);
        return;
    }
    towerOfHanoi(N-1, from, to, aux);
    printf("%c %c\n", from, to);
    towerOfHanoi(N-1, aux, from, to);
    return;
}