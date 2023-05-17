#include <stdio.h>
#include <stdlib.h>

typedef struct __node{
    char data;
    struct __node *left, *right;
}Node;
typedef struct __tree{
    struct __node *root;
}Tree;

Node *getNode(char data){
    if(data == '.')
        return NULL;

    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}
void linkNode(Node *parent, Node *left, Node *right){
    parent->left = left;
    parent->right = right;
}
Node *searchNode(Node *node, char data){
    if(node == NULL)
        return NULL;
    else if(node->data == data)
        return node;
    else{
        Node *ret = searchNode(node->left, data);
        if(ret != NULL)
            return ret;
    }
    return searchNode(node->right, data);
}
void preOrder(Node *node){
    if(node){
        printf("%c", node->data);
        preOrder(node->left);
        preOrder(node->right);
    }
}
void inOrder(Node *node){
    if(node){
        inOrder(node->left);
        printf("%c", node->data);
        inOrder(node->right);
    }
}
void postOrder(Node *node){
    if(node){
        postOrder(node->left);
        postOrder(node->right);
        printf("%c", node->data);
    }
}
void freeNode(Node *node){
    if(node){
        freeNode(node->left);
        freeNode(node->right);
        free(node);
    }
}

int main()
{
    Tree t;
    char parent, leftdata, rightdata;
    int N;
    scanf("%d", &N);
    getchar();

    scanf("%c %c %c", &parent, &leftdata, &rightdata);
    getchar();
    t.root = getNode(parent);
    linkNode(t.root, getNode(leftdata), getNode(rightdata));

    for(int i=1; i<N; i++){
        scanf("%c %c %c", &parent, &leftdata, &rightdata);
        getchar();
        Node *ptr = searchNode(t.root, parent);
        linkNode(ptr, getNode(leftdata), getNode(rightdata));
    }
    preOrder(t.root);
    printf("\n");
    inOrder(t.root);
    printf("\n");
    postOrder(t.root);
    printf("\n");

    freeNode(t.root);

    return 0;
}