/*
 * main.cc
 *
 *  Created on: 2017年5月30日
 *      Author: hello_chenchen
 */

//#include <iostream>
#include <iostream>
#include <string.h>

#define ASCII_NUM_ZERO '0'
#define ASCII_NUM_NINE '9'

using namespace std;

int MarkNum(char *pInStr, char *pOutStr)
{
    int ulCharLen = strlen(pInStr);
//    char* ptemp = NULL;
    string strTem = pInStr;

    bool flag = false;

    for(int i = 0; i < ulCharLen; i++)
    {
        if(ASCII_NUM_ZERO <= pInStr[i] && pInStr[i] <= ASCII_NUM_NINE)
        {
            string strTemp = pInStr;
            if(false == flag)
            {
                strTemp = strTemp.substr(0, i) + "*" + strTemp.substr(i, strTemp.length() - i);
                i++;
                flag = true;
            }
            else
            {
                strTemp = strTemp.substr(0, i+1) + "*" + strTemp.substr(i+1, strTemp.length() - i - 1);
                i++;
                flag = true;
            }
//            pInStr = strTemp.data();
        }
    }
    cout << "chenchen" << endl;

    pOutStr = pInStr;
    const char* p = strTem.c_str();
    cout << p << endl;
    if(0 == strcmp(pOutStr, p))
    {
        return -1;
    }
    else
    {
        return 0;
    }
}

int main(int argc, char **argv) {

    char* pInStr = new char;
    cin >> pInStr;

    char *pOutStr = NULL;
    int cc = MarkNum(pInStr, pOutStr);
    cout << pOutStr << endl;
    cout << "cc:" << cc << endl;

    return 0;
}



