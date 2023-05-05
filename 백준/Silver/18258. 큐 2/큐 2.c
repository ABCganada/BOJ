#include <stdio.h>
#include <string.h>

typedef struct __queue{
    int qArr[2000000];
    int front, rear;
}Q;

void initQ(Q *q);
void pushQ(Q *q, int data);
int popQ(Q *q);
int sizeQ(Q *q);
int isEmpty(Q *q);
int printFront(Q *q);
int printRear(Q *q);

int main()
{
    Q q;
    initQ(&q);

    char cmd[6];
    int i, N, data;
    scanf("%d", &N);
    getchar();

    for(i=0; i<N; i++){
        scanf("%s", cmd);

        if(!strcmp(cmd, "push")){
            scanf("%d", &data);
            getchar();

            pushQ(&q, data);
        }
        else if(!strcmp(cmd, "pop")){
            printf("%d\n", popQ(&q));
        }
        else if(!strcmp(cmd, "size")){
            printf("%d\n", sizeQ(&q));
        }
        else if(!strcmp(cmd, "empty")){
            printf("%d\n", isEmpty(&q));
        }
        else if(!strcmp(cmd, "front")){
            printf("%d\n", printFront(&q));
        }
        else if(!strcmp(cmd, "back")){
            printf("%d\n", printRear(&q));
        }
    }

    return 0;
}
void initQ(Q *q){
    q->front = 0;
    q->rear = 0;
}
void pushQ(Q *q, int data){
    q->rear = (q->rear+1) % (sizeof(q->qArr)/sizeof(int));
    q->qArr[q->rear] = data;
}
int popQ(Q *q){
    if(isEmpty(q))
        return -1;
    int ret = q->qArr[q->front+1];
    q->front = (q->front+1) % (sizeof(q->qArr)/sizeof(int));
    return ret;
}
int sizeQ(Q *q){
    return (q->rear > q->front ? q->rear - q->front : q->front - q->rear);
}
int isEmpty(Q *q){
    if(q->front == q->rear)
        return 1;
    else
        return 0;
}
int printFront(Q *q){
    if(isEmpty(q))
        return -1;
    return q->qArr[q->front+1];
}
int printRear(Q *q){
    if(isEmpty(q))
        return -1;
    return q->qArr[q->rear];
}