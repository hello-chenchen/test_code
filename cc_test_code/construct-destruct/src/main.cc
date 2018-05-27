#include "class_define.h"
#include "class_e.h"

ClassC c;
int main(int argc, char const *argv[])
{
    /* code */
    ClassA* pa = new ClassA();
    ClassB b;
    ClassE e;
    static ClassD d;
    delete pa;
    return 0;
}