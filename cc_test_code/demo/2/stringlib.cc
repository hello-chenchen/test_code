/*
 * stringlib.cc
 *
 *  Created on: May 30, 2017
 *      Author: hello_chenchen
 */

#include "stringlib.h"

namespace CC_lib
{

stringlib::stringlib()
{
    // TODO Auto-generated constructor stub

}

stringlib::~stringlib()
{
    // TODO Auto-generated destructor stub
}

//template<typename Container>
//Container& CC_lib::stringlib::split(Container& result,
//        const typename Container::value_type& s,
//        typename Container::value_type::value_type delimiter,
//        splitStruct::empties_t empties)
//{
//        result.clear();
//        std::istringstream ss( s );
//        while (!ss.eof())
//        {
//        typename Container::value_type field;
//        getline( ss, field, delimiter );
//        if ((empties == splitStruct::no_empties) && field.empty()) continue;
//        result.push_back( field );
//        }
//        return result;
//}
//template<typename Container>
//Container& stringlib::split(Container& result,
//        const typename Container::value_type& s,
//        typename Container::value_type::value_type delimiter,
//        split::empties_t empties)
//{
//    result.clear();
//    std::istringstream ss( s );
//    while (!ss.eof())
//    {
//    typename Container::value_type field;
//    getline( ss, field, delimiter );
//    if ((empties == split::no_empties) && field.empty()) continue;
//    result.push_back( field );
//    }
//    return result;
//}
} /* namespace CC_lib */
