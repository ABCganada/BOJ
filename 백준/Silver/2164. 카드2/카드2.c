#include <stdio.h>
#include <stdlib.h>

typedef struct __q{
    int front, rear;
    int qArr[500000];
}Q;

void init(Q *q){
    q->front = q->rear = 0;
}
void setQueue(Q *q, int N){
    int data = 1;
    while(data <= N){
        q->rear++;
        q->qArr[q->rear] = data++;
    }
}
void enqueue(Q *q, int data){
    q->rear = (q->rear+1) % 500000;
    q->qArr[q->rear] = data;
}
int dequeue(Q *q){
    q->front = (q->front +1) % 500000;
    return q->qArr[q->front];
}
int operate(Q *q){
    while(q->rear != (q->front+1)%500000){
        dequeue(q);
        int tmp = dequeue(q);
        enqueue(q, tmp);
    }
    return q->qArr[q->rear];
}

int main()
{
    Q q;
    init(&q);

    int N;
    scanf("%d", &N);

    setQueue(&q, N);
    printf("%d\n", operate(&q));

    return 0;
}