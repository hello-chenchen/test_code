#include <stdio.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    char str1[]="abc";
    char str2[]="abc";
    char *p1 = "abc";
    char *p2 = "abc";
    /* code */
    printf("abc: %p\n", "abc");
    printf("str1: %p\n", &(*str1));
    printf("str2: %p\n", &(*str2));
    printf("p1: %p\n", p1);
    printf("p2: %p\n", p2);
    sleep(600);
    return 0;
}
