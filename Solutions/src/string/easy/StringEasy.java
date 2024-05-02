package string.easy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class StringEasy {

    public static void main(String[] args) {
        String s = "(()())(())";
        String s1 = "23953767242388496965";
        largestOddNumber(s1);
        removeOuterParentheses(s);
    }

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
        // Write your code here.
        int max_depth = 0;
        int current_depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                current_depth++;
                max_depth = Math.max(max_depth, current_depth);
            } else if (c == ')') {
                if (current_depth > 0) {
                    current_depth--;
                } else {
                    // Handle the case when ')' is encountered before '('
                    return -1;  // Invalid input
                }
            }
        }

        return max_depth;
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


    public static String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) str.append(c);
            if (c == ')' && opened-- > 1) str.append(c);
        }
        return s.toString();
    }

    /*TODO You are given a string 'str' of length 'N'.



    Your task is to reverse the original string word by word.
    There can be multiple spaces between two words and there can be leading or trailing spaces but in the
     output reversed string you need to put a single space between two words, and your reversed string should not contain leading or trailing spaces.

     By using " +" as the delimiter, the split method will split the string str whenever it encounters one or more consecutive space characters. */
    public static String reverseString(String str) {
        //Write your code here
        String[] words = str.trim().split(" +");
        StringBuilder result = new StringBuilder();
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
/*TODO Problem statement
You are given an array ‘arr’ of ‘n’ strings.
Find the longest common prefix in all these strings.
If there is no common prefix in all the strings return "-1".
Example:
Input: 'arr' = [“abcd”, “abc”, “abref”, “abcde”]
Output: ab*/

    public static String commonPrefix(String []arr,int n){
        StringBuilder result = new StringBuilder();
        Arrays.sort(arr);
        char[] firstArr = arr[0].toCharArray();
        char[] last = arr[arr.length-1].toCharArray();
        for(int i =0;i<firstArr.length;i++){
            if(firstArr[i]!=last[i]){
                break;
            }
            result.append(firstArr[i]);
        }
        return result.toString();

    }

/*TODO: - You are given two strings 'str1' and 'str1'.



You have to tell whether these strings form an anagram pair or not.



The strings form an anagram pair if the letters of one string can be rearranged to form another string.

Pre-requisites:

Anagrams are defined as words or names that can be formed by rearranging the letters of another word. Such as "spar" can be formed by rearranging letters of "rasp". Hence, "spar" and "rasp" are anagrams.
Other examples include:

'triangle' and 'integral'
'listen' and 'silent'*/

    public static boolean isAnagram(String str1, String str2) {
        //Your code goes here
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            }
            int count = map.get(ch);
            if (count == 1) {
                map.remove(ch);
            } else {
                map.put(ch, count - 1);
            }
        }
        return map.isEmpty();

    }

    /*TODO: Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
            A shift on s consists of moving the leftmost character of s to the rightmost position.*/
    public boolean rotateString(String s, String goal) {
        for(int i =0;i<s.length();i++){
            String result = rotateByOne(s);
            if(result.equalsIgnoreCase(goal)){
                return true;
            }
        }
        return false;

    }
    public static String rotateByOne(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(c);
        return sb.toString();
    }









}
