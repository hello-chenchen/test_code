#include <stdio.h>

int foo() {
    for(int i = 0; i < 10; i++) {
        printf("ccc: %d\n", i);
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    foo();
    return 0;
}
