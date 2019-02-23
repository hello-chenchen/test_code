#include <iostream>

#include "clipboard.h"
#include "clipboard_x11.h"

using namespace std;
using namespace cclib;

int main(int argc, char const *argv[])
{
    /* code */
    Clipboard* cl = NULL;

    cl = new ClipboardX11();
    int value = cl->foo();

    cout << value << endl;

    delete cl;

    return 0;
}
