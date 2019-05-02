int add(int x, int y);
int sub(int x, int y);

int main() {
    int c = 30;
    int d[10];
    int *p=malloc(sizeof(int)*2);
    int *p1=malloc(sizeof(int));
    printf("-----static--------\n");
    printf("%x\n", &a);
    printf("%x\n", &b);
    printf("------stack-------\n");
    printf("%x\n", &c);
    printf("%x\n", &d);
    printf("%x\n", &p);
    printf("%x\n", &p1);
    add(a,b);
    sub(b,c);
    printf("------heap-------\n");
    printf("%x\n", p);
    printf("%x\n", p1);
    printf("------code-------\n");
    printf("%x\n", add);
    printf("%x\n", sub);
}

int add(int x, int y) {
    printf("%x\n", &x);
    printf("%x\n", &y);
    return x + y;
}

int sub(int x, int y) {
    printf("%x\n", &x);
    printf("%x\n", &y);
    return x - y;
}