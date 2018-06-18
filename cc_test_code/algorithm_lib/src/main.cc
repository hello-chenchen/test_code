#include <vector>
#include <iostream>
#include "vector_util.h"
// using namespace cc_alogrithm_lib;

int func() {
    vector<int> cc;
    cc.push_back(1);
    cc.push_back(2);
    cc.push_back(4);
    cc.push_back(5);
    cout<< cc_alogrithm_lib::vector_util::binarySearch(cc, 3) << endl;
}

int main(int argc, char const *argv[])
{
    /* code */
    func();
    return 0;
}
