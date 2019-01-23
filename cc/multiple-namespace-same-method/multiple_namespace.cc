//COMPILE: g++ multiple_namespace.cc -o main

#include <iostream>
using namespace std;

namespace first
{
     void myCout(void)
    {
        cout<<"Hello World is great\n";
    }
}

namespace second
{
     void myCout(void)
    {
        cout<<"Hello Sky is high\n";
    }
}

int main(void)
{
    second::myCout();
    first::myCout();
    return(0);
}