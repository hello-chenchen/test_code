#include <iostream>
#include <string>
#include <malloc.h>
using namespace std;  

int func() {
    string s = "hellohw";
    char * s1 = "hellohw";
    char s2[] = "hellohw";
    int s3[100];
    char* s4=(char*)malloc(100);
    void *s5=(void*)malloc(100);
    cout<<sizeof(s)<<endl;
    cout<<sizeof(s1)<<endl;
    cout<<sizeof(s2)<<endl;
    cout<<sizeof(s3)<<endl;
    cout<<sizeof(s4)<<endl;
    cout<<sizeof(s5)<<endl;
    cout<<sizeof(1)<<endl;

    free(s4);
    free(s5);
    return 0;
}

int main(int argc, char const *argv[])
{
    /* code */
    func();
    return 0;
}