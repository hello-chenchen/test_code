// #include "binary_search.h"
//     template <typename Comparable>
//     static int vectorTool::binarySearch(const vector<Comparable> & allItems, const Comparable & item){
//             int low = 0, high = allItems.size() - 1;
//             while(low <= high) {
//                 int mid = ( low + high ) / 2;
//                 if(allItems[mid] < item) {
//                     low = mid + 1;
//                 } else if(allItems[mid] > item) {
//                     high = mid - 1;
//                 } else {
//                     return mid;
//                 }
//             }
//             return -1;
//     }