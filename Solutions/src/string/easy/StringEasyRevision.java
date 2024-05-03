package string.easy;

import java.math.BigInteger;

public class StringEasyRevision {

    /*TODO You are given a string 'S' of length 'N' representing an integer.
        A string is a valid parenthesis if it satisfies one of the following conditions:
        If the string is empty or consists of a character other than ‘(‘ and ')'.
        If the string can be represented as a concatenation of two strings such that both strings are valid parentheses strings.
        If the string can be represented as '(A)', where A is a valid parenthesis.
        Depth of a string is defined as follows:
        depth( '' )=0
        depth( A )=0, where ‘A’ is an empty string or consists of a character other than ‘(‘ and ‘)’.
        depth( A+B )=max(depth( A ), depth( B )), such that ‘A’ and ‘B’ are both strings are valid parentheses strings.
        depth( (A) ) = 1+depth(A), where ‘A’ is a valid parentheses string.
        Given a valid parentheses string ‘S’, you must return the nesting depth of the string ‘S’.
        Example:
        Input:
        S = '1+(3*6+(9-3))', N=13
        Output: 2*/

    public static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if(c == ')'){
                if(currentDepth > 0){
                    currentDepth--;
                }else{
                    return -1;
                }
            }
        }
        return maxDepth;


    }

    /*TODO A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
        For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
        A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
        Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
        Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
            Input: s = "(()())()"
            Output: "()()()"
            Explanation:
            The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
            After removing outer parentheses of each part, this is "()()" + "()" = "()()()".*/

    public static String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int opened = 0;
        for(char c : S.toCharArray()){
            if(c == '(' && opened++ > 0){
                str.append('(');
            }if(c ==')' && opened-- > 1){
                str.append(')');
            }
        }
        return str.toString();
    }

     /*TODO You are given a string 'str' of length 'N'.



    Your task is to reverse the original string word by word.
    There can be multiple spaces between two words and there can be leading or trailing spaces but in the
     output reversed string you need to put a single space between two words, and your reversed string should not contain leading or trailing spaces.
*/
    public static String revverseString(String args) {
        StringBuilder result = new StringBuilder();
        String[] words = args.trim().split(" +");
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }


     /*TODO You are given a string num, representing a large integer.
        Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
        A substring is a contiguous sequence of characters within a string.*/

    public static String largestOddNumber(String num) {
        BigInteger result = BigInteger.ZERO;
        StringBuilder subString = new StringBuilder();
        char[] arr = num.toCharArray();
        for (char c : arr) {
            subString.append(c);
            BigInteger value = new BigInteger(subString.toString());
            if (value.mod(BigInteger.valueOf(2)).intValue() != 0 && value.compareTo(result) > 0) {
                result = value;
            }
        }
        if (result.equals(BigInteger.ZERO)) return "";
        return result.toString();
    }

}
