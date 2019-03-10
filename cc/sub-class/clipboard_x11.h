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

#ifndef CCLIB_CLIPBOARD_X11_H_
#define CCLIB_CLIPBOARD_X11_H_

#include "clipboard.h"

namespace cclib {

class ClipboardX11 : public Clipboard {

    public:
        ClipboardX11();
        ~ClipboardX11();

    public:
<<<<<<< HEAD
        size_t foo();
=======
        int foo();
>>>>>>> 1120dad925faec1a9751e91ee4188f3297a2dc4e
};  //class ClipboardX11

}   //namespace cclib

#endif  //CCLIB_CLIPBOARD_X11_H_