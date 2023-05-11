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
int sumStack(Stack *pstack){
    int i, sum = 0;
    int size = pstack->top;
    for(i=size; i>=0; i--){
        sum += pstack->stackArr[i];
    }
    return sum;
}

int main()
{
    Stack stack;
    init(&stack);
    int N, data;
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        scanf("%d", &data);
        if(data == 0)
            pop(&stack);
        else
            push(&stack, data);
    }
    printf("%d\n", sumStack(&stack));


    return 0;
}