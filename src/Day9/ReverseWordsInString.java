package Day9;

//Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
//Input:
//S = i.like.this.program.very.much
//Output: much.very.program.this.like.i
//Explanation: After reversing the whole
//string(not individual words), the input
//string becomes
//much.very.program.this.like.i

public class ReverseWordsInString {
    static String reverseWords(String S)
    {
        StringBuilder sb = new StringBuilder();
        String str[] = S.split("\\.");
        for(int i = str.length -1; i >= 0; i--){
            sb.append(str[i]);
            if(i != 0){
                sb.append(".");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }
}
