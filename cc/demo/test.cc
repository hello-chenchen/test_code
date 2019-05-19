#include <iostream>

using namespace std;

const int* foo(int a) {
    a = a + 1;
    return &a;
}

int main(int argc, char const *argv[])
{
    /* code */
    int a = 1;
    const int* b = foo(a);
    // a = 2;
    cout << a << endl;
    return 0;
}
