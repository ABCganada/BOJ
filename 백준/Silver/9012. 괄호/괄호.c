#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct __stack{
    int top;
    char stackArr[1001];
}Stack;

void init(Stack *pstack);
int isRight(Stack *pstack, char *str);
void push(Stack *pstack, char parenthesis);
void pop(Stack *pstack, char parenthesis);

int main()
{
    Stack stack;
    char str[51];
    int n, i;

    scanf("%d", &n);
    for(i=0; i<n; i++){
        init(&stack);
        scanf("%s", str);
        if(isRight(&stack, str))
            printf("YES\n");
        else
            printf("NO\n");
    }
    return 0;
}
void init(Stack *pstack){
    pstack->top = -1;
}
int isRight(Stack *pstack, char *str){
    int i = 0;

    while(str[i]){
        if(str[i] == '{' || str[i] == '[' || str[i] == '('){
            push(pstack, str[i]);
        }
        else if(str[i] == '}' || str[i] == ']' || str[i] == ')'){
            if(pstack->top < 0)
                return 0;
            pop(pstack, str[i]);
        }
        i++;
    }

    if(pstack->top == -1) 
        return 1;
    else 
        return 0;
}
void push(Stack *pstack, char parenthesis){
    pstack->top++;
    pstack->stackArr[pstack->top] = parenthesis;
}
void pop(Stack *pstack, char parenthesis){
    if(parenthesis == '}'){
        if(pstack->stackArr[pstack->top] == '{')
            pstack->top--;
    }
    else if(parenthesis == ']'){
        if(pstack->stackArr[pstack->top] == '[')
            pstack->top--;
    }
    else{
        if(pstack->stackArr[pstack->top] == '(')
            pstack->top--;
    }
}