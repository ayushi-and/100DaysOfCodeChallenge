package Day50;

import java.util.Stack;

/*----Basic Calculator
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

https://www.youtube.com/watch?v=BjDczS5uQ-g

Constraints:
1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation.
'-' could be used as a unary operation but it has to be inside parentheses.
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */
//Solved using stacks: hint- Calculator related problems solved using stack.
//TC: O(n) - n is string length
public class BasicCalculator {
    public static int calculate(String s) {
        int sign = 1; //for + sign
        int ans = 0;
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                currentNumber = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    currentNumber = currentNumber * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                currentNumber = currentNumber * sign;
                ans += currentNumber;
                currentNumber = 0;
                sign = 1;
            }
            else if(s.charAt(i) == '+') {
                sign = 1;
            }
            else if(s.charAt(i) == '-') {
                sign = -1; //-1 represents negative sign
            }
            else if(s.charAt(i) == '(') {
                stack.push(ans); //store the result calculated so far
                stack.push(sign); //store the last sign
                ans = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')') {
                int prevSign = stack.pop();
                ans = ans * prevSign;
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
