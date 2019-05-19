#include <iostream>

struct Node {
    Node* head;
    Node* tail;
    int data;
};

void foo() {
    Node* aa = new Node();
    Node* bb = new Node();
    Node* cc = new Node();
    aa->tail = bb;
    bb->tail = cc;

    int value = sizeof(Node);
    int value1 = sizeof(*aa);
    int value2 = sizeof(bb);
    int value3 = sizeof(cc);
    int value4 = cc - aa;

    std::cout << value << std::endl;
    std::cout << value1 << std::endl;
    std::cout << value2 << std::endl;
    std::cout << value3 << std::endl;
    std::cout << value4 << std::endl;
}

int main(int argc, char const *argv[])
{
    /* code */
    foo();
    return 0;
}
