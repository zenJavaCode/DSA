package string.medium;

import java.util.*;

public class StringMedium {

    public static void main(String[] args) {
        String s = "aacfssa";
        System.out.println(  countSubStrings(s,3));
    }


    public String frequencySort(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                ans.append(ch);
            }
        }
        return ans.toString();

    }

    /*TODO FIND ATOI
    *  Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Edge case: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.*/

    public int myAtoi(String s) {
        int ans=0;
        int i=0;
        int sign=1;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        if(s.length()==0){
            return 0;
        }
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }

        if(i<s.length() && (s.charAt(i)=='-'|| s.charAt(i)=='+')){
            if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
        while(i<s.length() && s.charAt(i)-'0'<=9 && s.charAt(i)-'0'>=0){
            int digit = s.charAt(i)-'0';
            if(ans>max/10 || (ans==max/10 && digit>max%10)){
                return (sign == 1) ? max : min;
            }
            ans=ans*10+digit;
            i++;
        }
        return ans*sign;
    }

/*TODO You are given a string 'str' of lowercase alphabets and an integer 'k' .



Your task is to return the count all the possible substrings that have exactly 'k' distinct characters.



For example:

'str' = abcad and 'k' = 2.

We can see that the substrings {ab, bc, ca, ad} are the only substrings with 2 distinct characters.

Therefore, the answer will be 4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
aacfssa
3
Sample Output 1 :
5
Explanation of The Sample Input 1:
Given 'str' = “aacfssa”. We can see that the substrings with only 3 distinct characters are {aacf, acf, cfs, cfss, fssa}.

Therefore, the answer will be 5.
Sample Input 2 :
qffds
4
Sample Output 2 :
1
Constraints:
1 <= |str| <= 10^5
1 <= k <= 26

Time Limit: 1 second
*/

    public static int countSubStrings(String str, int k) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i =0;i<k;i++){
            sb.append(str.charAt(i));
        }
        for(int i =k;i<str.length();i++){
            String temp=sb.toString();
            sb.deleteCharAt(0);
            sb.append(str.charAt(i));

            if(!sb.toString().equals(temp)){
                count++;
            }
        }
        return count;
    }











}
