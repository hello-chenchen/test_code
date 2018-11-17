#include <stdio.h>

int foo(int x)
{
    return x&(-x);
}

int main(int argc, char const *argv[])
{
    /* code */
    int b = 2^31;
    printf("b: %d\n", b);
    int a = foo(2^31 - 3);
    printf("a: %d\n", a);
    return 0;
}
