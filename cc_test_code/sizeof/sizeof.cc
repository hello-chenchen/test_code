#include <iostream>  
#include <string>  
using namespace std;  

int _tmain(int argc, _TCHAR* argv[])  
{  
    string s = "hellohwc";  
    char * s1 = "hellohwc";  
    char s2[] = "hellohwc";  
    char s3[100];  
    char* s4=(char*)malloc(100);  
    void *s5=(void*)malloc(100);  
    cout<<sizeof(s)<<endl;  
    cout<<sizeof(s1)<<endl;  
    cout<<sizeof(s2)<<endl;  
    cout<<sizeof(s3)<<endl;  
    cout<<sizeof(s4)<<endl;  
    cout<<sizeof(s5)<<endl;  
    return 0;  
}  