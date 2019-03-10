#include <iostream>

#include "clipboard.h"

using namespace std;
using namespace cclib;

int main(int argc, char const *argv[])
{
    /* code */
    Clipboard* cc = new Clipboard();

    cout << cc->foo() << endl;

    delete cc;

    return 0;
}
