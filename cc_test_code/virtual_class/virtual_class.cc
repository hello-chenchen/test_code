#include <iostream>

using namespace std;

class ParentClass {
    public:
    virtual int func() {
        cout << "ParemtClass func" << endl;
        return 0;
    }
};

class SubAClass : public ParentClass {
    public:
    int func() {
        cout << "SubAClass func" << endl;
        return 1;
    }
};

class SubBClass : public ParentClass {
    public:
    int func() {
        cout << "SubBClass func" << endl;
        return 2;
    }
};

int main() {
    ParentClass *c1 = new SubAClass();
    ParentClass *c2 = new SubBClass();
    c1->func();
    c2->func();
}