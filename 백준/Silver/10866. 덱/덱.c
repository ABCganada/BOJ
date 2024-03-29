#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct __deque{
    struct __node *front, *rear;
}Deque;

typedef struct __node{
    int data;
    struct __node *prev, *next;
}Node;

void initDeque(Deque *dq);
int isEmpty(Deque *dq);
void addFront(Deque *dq, int data);
void addRear(Deque *dq, int data);
int delFront(Deque *dq);
int delRear(Deque *dq);
void printDeque(Deque *dq);
void freeDeque(Deque *dq);

int main()
{
    Deque deque;
    initDeque(&deque);

    char cmd[11];
    int N, data, flag;
    scanf("%d", &N);
    getchar();

    for(int i=0; i<N; i++){
        scanf("%s", cmd);
        if(!strcmp(cmd, "push_front")){
            scanf("%d", &data);
            getchar();

            addFront(&deque, data);
        }
        else if(!strcmp(cmd, "push_back")){
            scanf("%d", &data);
            getchar();

            addRear(&deque, data);
        }
        else if(!strcmp(cmd, "pop_front")){
            printf("%d\n", delFront(&deque));
        }
        else if(!strcmp(cmd, "pop_back")){
            printf("%d\n", delRear(&deque));
        }
        else if(!strcmp(cmd, "size")){
            Node *ptrNode = deque.front;
            int cnt = 0;
            while(ptrNode){
                cnt++;
                ptrNode = ptrNode->next;
            }
            printf("%d\n", cnt);
        }
        else if(!strcmp(cmd, "empty")){
            printf("%d\n", isEmpty(&deque));
        }
        else if(!strcmp(cmd, "front")){
            if(isEmpty(&deque))
                printf("-1\n");
            else
                printf("%d\n", deque.front->data);
        }
        else if(!strcmp(cmd, "back")){
            if(isEmpty(&deque))
                printf("-1\n");
            else
                printf("%d\n", deque.rear->data);
        }
        // else if(!strcmp(cmd, "P")){
        //     printDeque(&deque);
        // }
    }

    freeDeque(&deque);

    return 0;
}
void initDeque(Deque *dq){
    dq->front = dq->rear = NULL;
}
int isEmpty(Deque *dq){
    if(dq->front == NULL)
        return 1;
    else
        return 0;
}
void addFront(Deque *dq, int data){
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->prev = NULL;

    if(isEmpty(dq)){
        newNode->next = NULL;
        dq->front = newNode;
        dq->rear = newNode;
        return;
    }
    newNode->next = dq->front;
    dq->front->prev = newNode;
    dq->front = newNode;
}
void addRear(Deque *dq, int data){
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;

    if(isEmpty(dq)){
        newNode->prev = NULL;
        dq->front = newNode;
        dq->rear = newNode;
        return;
    }
    newNode->prev = dq->rear;
    dq->rear->next = newNode;
    dq->rear = newNode;
}
int delFront(Deque *dq){
    if(isEmpty(dq))
        return -1;
    
    Node *delNode = dq->front;
    int ret = delNode->data;
    if(delNode->prev == NULL && delNode->next == NULL){
        free(delNode);
        initDeque(dq);
        return ret;
    }
    dq->front = dq->front->next;
    dq->front->prev = NULL;
    
    free(delNode);

    return ret;
}
int delRear(Deque *dq){
    if(isEmpty(dq))
        return -1;

    Node *delNode = dq->rear;
    int ret = delNode->data;
    if(delNode->prev == NULL && delNode->next == NULL){
        free(delNode);
        initDeque(dq);
        return ret;
    }
    dq->rear = dq->rear->prev;
    dq->rear->next = NULL;
    
    free(delNode);

    return ret;
}
void printDeque(Deque *dq){
    Node *ptrNode = dq->front;
    while(ptrNode){
        printf(" %d", ptrNode->data);
        ptrNode = ptrNode->next;
    }
    printf("\n");
}
void freeDeque(Deque *dq){
    Node *cur = dq->front;
    while(cur){
        Node *next = cur->next;
        free(cur);
        cur = next;
    }
}