#include <stdio.h>

typedef struct {
    int param;
    int param1;
    char param2[];
}ZeroArray;

int main(int argc, char const *argv[])
{
    /* code */
    printf("sizeof int: %d \n", sizeof(int));
    printf("sizeof ZeroArray: %d \n", sizeof(ZeroArray));
    return 0;
}
