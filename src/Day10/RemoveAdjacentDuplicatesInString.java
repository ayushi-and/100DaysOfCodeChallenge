package Day10;

import java.util.Stack;

//You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
//causing the left and the right side of the deleted substring to concatenate together.
//We repeatedly make k duplicate removals on s until we no longer can.
//Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation:
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa"
public class RemoveAdjacentDuplicatesInString {
    public static String removeDuplicates(String s, int k){
        Stack<pair> st = new Stack<>();
        char arr[] = s.toCharArray();
        for(char c : arr) {
            if(st.isEmpty()) {
                st.push(new pair(c, 1));
            }
            else if(c == st.peek().ch){
                if(st.peek().freq == k-1){
                    st.pop();
                }
                else{
                    st.push(new pair(c, st.pop().freq+1));
                }
            }
            else{
                st.push(new pair(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            for(int i = 0; i < st.peek().freq; i++){
                sb.append(st.peek().ch);
            }
            st.pop();
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
class pair{
    Character ch;
    int freq;

    pair(char c,int k){
        this.ch=c;
        this.freq=k;
    }
}
