#include <iostream>

using namespace std;

class classA{
    public:
        classA(int a) :a(a) {}
        ~classA() {
            cout << "~classA" << a << endl;
        }

    public:
        int a;
 };

struct Node {
    Node(classA* a): data(a) {}
    Node* head;
    Node* tail;
    classA* data;
};

void foo() {
    classA* a = new classA(1);
    Node* aa = new Node(a);
    classA* b = new classA(2);
    Node* bb = new Node(b);
    classA* c = new classA(3);
    Node* cc = new Node(c);
    delete aa->data;
    delete aa;
}

classA foo1() {
    return classA(22);
}

int main(int argc, char const *argv[])
{
    /* code */
    classA c = foo1();
    cout << c.a << endl;
    return 0;
}
