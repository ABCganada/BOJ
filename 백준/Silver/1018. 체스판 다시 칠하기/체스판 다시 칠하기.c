#include <stdio.h>

int check(char board[][50], int col, int low){
    int i, j;
    int flag, cnt1 = 0, cnt2 = 0;

    flag = 0;
    for(i=col; i<col+8; i++){
        for(j=low; j<low+8; j++){
            if(j==low){
                if(flag==0 && board[i][j] == 'W' || flag==1 && board[i][j] == 'B'){
                    cnt1++;
                }
                continue;
            }
            else if(flag==0 && board[i][j] == 'B' || flag==1 && board[i][j] == 'W'){
                cnt1++;
            }
            if(flag==0)
                flag = 1;   
            else
                flag = 0;
        }
    }

    flag = 1;
    for(i=col; i<col+8; i++){
        for(j=low; j<low+8; j++){
            
            if(j==low){
                if(flag==0 && board[i][j] == 'W' || flag==1 && board[i][j] == 'B'){
                    cnt2++;
                }
                continue;
            }
            else if(flag==0 && board[i][j] == 'B' || flag==1 && board[i][j] == 'W'){
                cnt2++;
            }
            if(flag==0)
                flag = 1;   
            else
                flag = 0;
        }
    }

    if(cnt1<cnt2)
        return cnt1;

    return cnt2;
}

int main()
{
    char board[50][50];
    int N, M;
    scanf("%d%d", &N, &M);
    getchar();

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            scanf("%c", &board[i][j]);
        }
        getchar();
    }

    int tmp, min = 0;
    min = check(board, 0, 0);
    for(int i=0; i<=N-8; i++){
        for(int j=0; j<=M-8; j++){
            tmp = check(board, i, j);
            if(min > tmp)
                min = tmp;
        }
    }

    printf("%d\n", min);

    return 0;
}