#include <iostream>
using namespace std;

int func() {
    int i = 0;
    cout << i++ << endl;
    cout << ++i << endl;
    i = 0;
    // i++ = 3;
    cout << i << endl;

    ++i = 4;
    cout << i << endl;
}

int main(int argc, char const *argv[])
{
    /* code */
    func();
    return 0;
}
