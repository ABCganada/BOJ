#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct __stack{
    int top;
    char *stackArr;
}Stack;

void init(Stack *pstack);
int isRight(Stack *pstack, char *str);
void push(Stack *pstack, char parenthesis);
int pop(Stack *pstack, char parenthesis);

int main()
{
    Stack stack;
    char str[101];

    while(1){
        init(&stack);
        gets(str);
        if(!strcmp(str, "."))
            break;
        
        if(isRight(&stack, str) && str[strlen(str) - 1] == '.')
            printf("yes\n");
        else
            printf("no\n");
        
        free(stack.stackArr);
    }

    return 0;
}
void init(Stack *pstack){
    pstack->top = -1;
    pstack->stackArr = (char *)malloc(sizeof(char) * 101);
}
int isRight(Stack *pstack, char *str){
    int i = 0;
    int flag;

    while(str[i]){
        if(str[i] == '[' || str[i] == '('){
            push(pstack, str[i]);
        }
        else if(str[i] == ']' || str[i] == ')'){
            if(pstack->top < 0)
                return 0;

            flag = pop(pstack, str[i]);
            if(!flag)
                return 0;
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
int pop(Stack *pstack, char parenthesis){
    if(parenthesis == ']'){
        if(pstack->stackArr[pstack->top] == '[')
            pstack->top--;
        else
            return 0;
    }
    else{
        if(pstack->stackArr[pstack->top] == '(')
            pstack->top--;
        else
            return 0;
    }
    return 1;
}