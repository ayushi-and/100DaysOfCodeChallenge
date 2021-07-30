package Day16;

//Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
//For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
//Example 1:
//Input:
//{([])}
//Output:
//true
//Explanation:
//{ ( [ ] ) }. Same colored brackets can form
//balanced pairs, with 0 number of
//unbalanced bracket.
//Example 3:
//Input:
//([]
//Output:
//false
//Explanation:
//([]. Here square bracket is balanced but
//the small bracket is not balanced and
//Hence , the output will be unbalanced.

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {
    static boolean isPar(String str) {

        // Using ArrayDeque is faster than using Stack class. Also, Stack is synchronized, so lowers performance
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if(x == '(' || x == '[' || x == '{') {
                stack.push(x);
            }
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if(stack.isEmpty()) {
                return false;
            }
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '[') {
                        return false;
                    }
                    break;
                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '[') {
                        return false;
                    }
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '(' || check == '{') {
                        return false;
                    }
                    break;
            }

        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {

        System.out.println(isPar("([]"));
        System.out.println(isPar("{([])}"));
        System.out.println(isPar("()"));
    }
}