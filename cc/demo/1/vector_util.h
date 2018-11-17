#ifndef CC_BINARY_SEARCH_H
#define CC_BINARY_SEARCH_H
#include <vector>
#include "algorithm_def.h"

namespace cc_alogrithm_lib {
    template <typename Comparable>
    class vector_util {
        public:
        static int binarySearch(const vector<Comparable> & allItems, const Comparable & item);
    };
}
#endif