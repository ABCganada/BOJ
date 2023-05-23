#include <stdio.h>

typedef struct __stack{
    int top;
    int stackArr[80001];
}Stack;

void init(Stack *stack){
    stack->top = -1;
}
void push(Stack *stack, int data){
    stack->stackArr[++stack->top] = data;
}
int pop(Stack *stack){
    return stack->stackArr[stack->top--];
}
int top(Stack *stack){
    return stack->stackArr[stack->top];
}

int main()
{
    Stack s;
    init(&s);
    int N;
    long long cnt = 0;
    scanf("%d", &N);
    int buildingHeight[N];

    for(int i=0; i<N; i++){
        scanf("%d", &buildingHeight[i]);
    }

    push(&s, buildingHeight[0]);
    for(int i=1; i<N; i++){
        if(buildingHeight[i] >= top(&s)){
            while(buildingHeight[i] >= top(&s) && s.top >= 0)
                pop(&s);
        }
        push(&s, buildingHeight[i]);
        cnt += s.top;
    }
    printf("%lld\n", cnt);

    return 0;
}