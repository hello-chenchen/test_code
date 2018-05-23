#include <iostream>
#include <typeinfo>

using namespace std;

int func() {
    int a = 0;
    cout << "typeid int :" << typeid(a).name() << endl;
}

int main(int argc, char const *argv[])
{
    /* code */
    func();
    return 0;
}
