/*
 * stringlib.h
 *
 *  Created on: May 30, 2017
 *      Author: hello_chenchen
 */

#ifndef LIB_STRINGLIB_H_
#define LIB_STRINGLIB_H_

#include <sstream>
#include <string>

//using namespace std;

struct splitStruct
{
    enum empties_t
    {
        empties_ok, no_empties
    };
};

namespace CC_lib
{

class stringlib
{
public:
    stringlib();
    virtual ~stringlib();


    template<typename Container>
    Container& split(Container& result, const typename Container::value_type& s,
            typename Container::value_type::value_type delimiter,
            splitStruct::empties_t empties = splitStruct::empties_ok);

};

} /* namespace CC_lib */

template<typename Container>
inline Container& CC_lib::stringlib::split(Container& result,
        const typename Container::value_type& s,
        typename Container::value_type::value_type delimiter,
        splitStruct::empties_t empties)
{
    result.clear();
    std::istringstream ss( s );
    while (!ss.eof())
    {
    typename Container::value_type field;
    getline( ss, field, delimiter );
    if ((empties == splitStruct::no_empties) && field.empty()) continue;
    result.push_back( field );
    }
    return result;
}

#endif /* LIB_STRINGLIB_H_ */
