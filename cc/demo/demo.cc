#include <iostream>
#include <vector>
#include <string>
#include <new>

using namespace std;

void foo() {
    int a[4][3]={1,2,3,4,5,6,7,8,9,10,11,12}, (*prt)[3]=a,*p=a[0];
    cout << *(*(a+1)+2) << endl;
}

void vectorTest() {
    vector<int> cc;
    cc.push_back(1);
    cc.push_back(2);

    auto aa = cc.begin();

    aa++;
    cout << *aa << endl;

    int b = 0;
    auto a = b;
    cout << a <<endl;
}

void arrayTest() {
    int cc[1] = {1};
    cout << cc[0] << endl;
    cout << cc[1] << endl;
    cout << cc[10] << endl;
}

int main(int argc, char const *argv[])
{
    /* code */
    vectorTest();
    return 0;
}
