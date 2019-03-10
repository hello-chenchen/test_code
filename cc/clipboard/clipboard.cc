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

#include "clipboard.h"

namespace cclib {
Clipboard::Clipboard() {
    flag = 100;
}

Clipboard::~Clipboard() {

}
//TODO:
// Nan::Persistent<FunctionTemplate> Clipboard::constructor_template;

int Clipboard::foo() {
    return flag;
}

} //namespace cclib