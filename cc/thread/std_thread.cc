#include <thread>
#include <stdio.h>
using namespace std;

int _global_num = 0;

void func(int param) {
    _global_num += param;
    printf("param: %d _global_num: %d\n", param, _global_num);
}

int main(int argc, char const *argv[])
{
    /* code */
    for(int i=0;i < 5; i++) {
        thread t(func, i);
        t.join();   //阻塞式
    }
    return 0;
}
