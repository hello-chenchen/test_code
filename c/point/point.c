#include<stdio.h>

char *myString(char** param) {
    char buffer[6] = {0};
    char *s = "Hello World!";
    for (int i = 0; i < sizeof(buffer) - 1; i++)
    {
        buffer[i] = *(s + i);
    }
    printf("cc:%s\n", buffer);
    *param = buffer;
    return buffer;
}

char *mystring() {
    char buffer[6] = {0};
    char *s = "Hello World!";
    for (int i = 0; i < sizeof(buffer) - 1; i++)
    {
        buffer[i] = *(s + i);
    }
    printf("cc:%s\n", buffer);
    return buffer;
}

int main(int argc, char **argv) {
    char* *a[6];
    myString(a);
    printf("ccc: %s\n", *a);
    return 0;
}
