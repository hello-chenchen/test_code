#ifndef CC_CONTAINER_UTIL_H
#define CC_CONTAINER_UTIL_H
#include <vector>
#include <list>

using namespace std;

namespace cc_alogrithm_lib {
    class container_util {
        public:
        template<typename Container, typename Object>
        static void changeElement(Container & c, const Object & element) {
            typename Container::iterator itr=c.begin();
            while( itr != c.end() ){
                cout << *itr << endl;
                cout << element << endl;
                // cout << c.end() << endl;
                *itr++ = element;
            }
        };
    };
}

#endif