/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 */

class Solution {
    public int computation(int val1, int val2, String op) {
        int res = 0;
        switch (op) {
            case "+":
                res = val2 + val1;
                break;
            case "-":
                res = val2 - val1;
                break;
            case "*":
                res = val2 * val1;
                break;
            case "/":
                res = val2 / val1;
                break;
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> token = new Stack<>();
        int result;
        for (String i : tokens) {
            if (!token.isEmpty() && Arrays.asList("+", "-", "*", "/").contains(i)) {
                result = computation((int) token.pop(), (int) token.pop(), i);
                token.push(result);
            } else {
                token.push(Integer.parseInt(i));
            }
        }
        return token.pop();
    }
}
