#define MAX 100
typedef struct staticStack {
    int sp;
    int values [MAX];
} STACK, *SStack;

typedef struct dinStack {
    int sp;
    int size;
    int *values;
} *DStack;