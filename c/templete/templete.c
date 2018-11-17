// #define add(t, a, b) (add_## t ((a), (b)))

//int 类型add
// #define _type int
// #define _func add_int
#include "add.h"

//char 类型add
// #define _type float
// #define _func add_float
// #include "add.h"

// #define CC_PRINT(t) printf(t)

#include <stdio.h>

int main(int argc, char const *argv[])
{
    /* code */

    func();

    //预处理操作
    // #ifdef FUCK
    // printf("FUCK func\n");
    // #else
    // printf("FUCK1 func\n");
    // #endif
    // int cc = 12;
    // CC_PRINT("func call\n");

    // int c = add(int, 12, 22);
    // printf("c: %d\n", c);

    // float d = add(float, 12L, 22L);
    // printf("d: %f\n", d);

    return 0;
}