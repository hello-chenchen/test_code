/*********************************************************************
 * node-clipboard
 *
 * Copyright (c) 2019 node-clipboard contributors:
 *   - hello_chenchen <https://github.com/hello-chenchen>
 *
 * MIT License <https://github.com/hello-chenchen/node-clipboard/blob/master/LICENSE>
 * See https://github.com/hello-chenchen/node-clipboard for the latest update to this file
 *
 * author: hello_chenchen <https://github.com/hello-chenchen>
 **********************************************************************************/

#ifndef CCLIB_CLIPBOARD_H_
#define CCLIB_CLIPBOARD_H_

namespace cclib {

class Clipboard {
public:
    //TODO:
    Clipboard();
    ~Clipboard();
    int foo();

private:

    int flag;
}; //class clipboard

} //namespace cclib

#endif  // CCLIB_CLIPBOARD_H_