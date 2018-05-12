#include <iostream>

using namespace std;

class ParentClass {
    public:
        virtual ~ParentClass() {
            cout << "~ ParentClass" << endl;
        }
    public:
    virtual int func() = 0;
};

class SubAClass : public ParentClass {
    public:
        ~SubAClass() {
            cout << "~ SubAClass" << endl;
        }
    public:
    int func() {
        cout << "SubAClass func" << endl;
        return 1;
    }
};

class SubBClass : public ParentClass {
    public:
        ~SubBClass() {
            cout << "~ SubBClass" << endl;
        }
    public:
    int func() {
        cout << "SubBClass func" << endl;
        return 2;
    }
};

int main() {
    ParentClass *c = new ParentClass{
        virtual int func(){}
    };
    // ParentClass *c1 = new SubAClass();
    // ParentClass *c2 = new SubBClass();
    // c1->func();
    // c2->func();
    c->func();

    // delete c1;
}