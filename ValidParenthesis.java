/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
 */

//learning git commands

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty())
                    return false;
                char t = st.peek();
                if ((c == ')' && t != '(') || (c == ']' && t != '[') || (c == '}' && t != '{')) {
                    return false;
                } else {
                    st.pop();
                }
            }

        }

        if (!st.isEmpty())
            return false;

        return true;
    }
}