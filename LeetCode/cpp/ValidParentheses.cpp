#include <iostream>  
#include <stdio.h>
#include <stack>
#include <string>

using std::string;
using std::stack;
using std::cout;
using std::endl;


/**
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
bool isValid(string s) {
    stack<char> st;
	st.push('#');
    for (auto t1 : s){
        char t = st.top();
		if (t1 == '{' || t1 == '[' || t1 == '('){
			st.push(t1);
		}else if (t1 == '}'){
			if (t == '{' ){
				st.pop();
			}else{
			    return false;
			}
		}else if (t1 == ']'){
			if (t == '[' ){
				st.pop();
			}else{
			    return false;
			}
		}else if (t1 == ')'){
			if (t == '(' ){
				st.pop();
			}else{
			    return false;
			}
		}
	}
	return (st.top() == '#' ? true : false);
}

int main(int argc, char *argv[])
{
    string s0 = "{}";
	string s1 = "[{}]))";
	string s2 = "ab(c[f])";
    for (auto t1 : s0){
        cout << t1 << endl;
	}
	cout << s0 <<": " << isValid(s0) << endl;
    cout << s1 <<": " << isValid(s1) << endl;
	cout << s2 <<": " << isValid(s2) << endl;
	return 0;
}
