#include <stdio.h>

int func() {
    printf("sizeof(short:%d) sizeof(int:%d) sizeof(long:%d) sizeof(point:%d)\n",
            sizeof(short), sizeof(int), sizeof(long), sizeof(char*));
    return 0;
}

int func1() {
    printf("this func is :%s\n", __TIME__);
}

int main(int argc, char const *argv[])
{
    /* code */
    func1();

    return 0;
}