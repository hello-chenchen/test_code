#ifndef CC_BINARY_SEARCH_H
#define CC_BINARY_SEARCH_H
#include <vector>
#include "algorithm_def.h"

namespace cc_alogrithm_lib {
    class vectorUtil {
        public:
        template <typename Comparable>
        static int binarySearch(const vector<Comparable> & allItems, const Comparable & item){
            int low = 0, high = allItems.size() - 1;
            while(low <= high) {
                int mid = ( low + high ) / 2;
                if(allItems[mid] < item) {
                    low = mid + 1;
                } else if(allItems[mid] > item) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        };
    };
}
#endif