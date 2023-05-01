#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct __stack{
    int top;
    double stack[101];
}Stack;

double evaluate(char postfix[], int operandArr[]);
void init(Stack *pstack);
void push(Stack *pstack, double operand);
double pop(Stack *pstack);
double top(Stack *pstack);
double operate(double a, double b, char c);
void print(Stack *pstack);

int main()
{
    char postfix[101];
    int i, operandNum;

    scanf("%d", &operandNum);
    getchar();
    scanf("%s", postfix);

    int operandArr[operandNum];

    for(i=0; i<operandNum; i++){
        scanf("%d", &operandArr[i]);
    }
    printf("%.2lf\n", evaluate(postfix, operandArr));

    return 0;
}
double evaluate(char postfix[], int operandArr[]){
    Stack stack;
    init(&stack);

    char c, alp = 'A';
    int i = 0;
    double a, b;

    while(postfix[i]){
        // printf("---- current postfix ----\n");
        // printf("%s\n", &postfix[i+1]);
        c = postfix[i];

        if(c=='+' || c=='-' || c=='*' || c=='/'){
            a = pop(&stack);
            b = pop(&stack);
            push(&stack, operate(b, a, c));
        }
        else{
            push(&stack, (double)operandArr[c-alp]);
        }
        // print(&stack);
        i++;
    }
    return pop(&stack);
}
void init(Stack *pstack){
    pstack->top = -1;
}
void push(Stack *pstack, double operand){
    pstack->stack[++pstack->top] = operand;
}
double pop(Stack *pstack){
    return pstack->stack[pstack->top--];
}
double top(Stack *pstack){
    return pstack->stack[pstack->top];
}
double operate(double a, double b, char c){
    if(c == '*')
        return a*b;
    else if(c == '/')
        return a/b;
    else if(c == '+')
        return a+b;
    else
        return a-b;
    return 0;
}
void print(Stack *pstack){
    printf("==== current STACK ====\n");
    int i = pstack->top;
    while(i>=0)
        printf(" %.2lf", pstack->stack[i--]);
    printf("\n\n");
}