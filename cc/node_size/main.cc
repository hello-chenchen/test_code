#include <iostream>
#include "classA.h"

using namespace std;

// classA<int> foo() {
//     return classA<int>(2);
// }

// classA<int> foo1(classA<int> a) {
//     a.foo1(4);
//     return a;
// }

int main() {
    Node<int>* cc = new Node<int>(4);
    Node<int>* dd = new Node<int>(5);
    cc->next = dd;
    classA<int> a = classA<int>(dd);
    cout << a.foo() << endl;
    a.pop_back();
    return 0;
}