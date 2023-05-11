#include <stdio.h>
#include <string.h>

typedef struct __stack{
    int top;
    int stackArr[100000];
}Stack;

void init(Stack *pstack){
    pstack->top = -1;
}
void push(Stack *pstack, int data){
    pstack->stackArr[++pstack->top] = data;
}
int pop(Stack *pstack){
    return pstack->stackArr[pstack->top--];
}
int top(Stack *pstack){
    return pstack->stackArr[pstack->top];
}
void makeSeq(int targetSeq[], int N){
    Stack stack;
    init(&stack);
    
    char str[1000000];

    int i=0, j=0;
    int data = 1;

    while(data <= N){
        int target = targetSeq[i];

        if(data <= target){
            while(data <= target){
                push(&stack, data++);
                str[j++] = '+';
            }
            pop(&stack);
            str[j++] = '-';
        }
        else{
            if(top(&stack) != target){
                printf("NO\n");
                return;
            }
            pop(&stack);
            str[j++] = '-';
        }
        i++;
    }
    while(i < N){
        if(top(&stack) != targetSeq[i]){
            printf("NO\n");
            return;
        }
        else{
            pop(&stack);
            str[j++] = '-';
            i++;
        }
    }
    str[j] = '\0';
    i=0;
    while(str[i])
        printf("%c\n", str[i++]);
}


int main()
{
    int N, targetSeq[100000];
    scanf("%d", &N);
    for(int i=0; i<N; i++)
        scanf("%d", &targetSeq[i]);
    
    makeSeq(targetSeq, N);


    return 0;
}