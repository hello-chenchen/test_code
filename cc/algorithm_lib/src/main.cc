#include <vector>
#include <iostream>
#include "../inc/vector_util.h"
#include "../inc/container_util.h"
using namespace cc_alogrithm_lib;

int func() {
    vector<int> cc;
    cc.push_back(1);
    cc.push_back(2);
    cc.push_back(4);
    cc.push_back(5);
    // cout<< vector_util<int>::binarySearch(cc, 3) << endl;

    container_util::changeElement(cc, 100);
    vector<int>::iterator itr = cc.begin();
    while(itr != cc.end()) {
        cout<< *itr << endl;
        ++itr;
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    func();
    return 0;
}
