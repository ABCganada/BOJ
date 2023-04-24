#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct __stack{
    int top;
    int *stackArr;
}Stack;

void init(Stack *pstack);
void push(Stack *pstack, int data);
int pop(Stack *pstack);
int size(Stack *pstack);
int isEmpty(Stack *pstack);
int top(Stack *pstack);


int main()
{
    Stack stack;
    char cmd[10];
    int i, calNum;

    scanf("%d", &calNum);
    getchar();

    stack.stackArr = (int *)malloc(sizeof(int) * calNum);  // 스택 초기화
    init(&stack);

    for(i=0; i<calNum; i++){
        scanf("%s", cmd);
        getchar();

        if(!strcmp(cmd, "pop")){            // pop
            int ret = pop(&stack);
            printf("%d\n", ret);
        }
        else if(!strcmp(cmd, "push")){      // push
            int data;
            scanf("%d", &data);
            getchar();

            push(&stack, data);
        }
        else if(!strcmp(cmd, "size")){      // size
            printf("%d\n", size(&stack));
        }
        else if(!strcmp(cmd, "empty")){     // empty
            printf("%d\n", isEmpty(&stack));
        }
        else if(!strcmp(cmd, "top")){       // top
            printf("%d\n", top(&stack));
        }
    }

    free(stack.stackArr);

    return 0;
}
void init(Stack *pstack){
    pstack->top = -1;
}
void push(Stack *pstack, int data){
    pstack->top++;
    pstack->stackArr[pstack->top] = data;
}
int pop(Stack *pstack){
    if(pstack->top < 0)
        return -1;

    pstack->top--;
    return pstack->stackArr[pstack->top+1];
}
int size(Stack *pstack){
    return pstack->top + 1;
}
int isEmpty(Stack *pstack){
    if(pstack->top == -1)
        return 1;
    else
        return 0;
}
int top(Stack *pstack){
    if(isEmpty(pstack))
        return -1;
    return pstack->stackArr[pstack->top];
}