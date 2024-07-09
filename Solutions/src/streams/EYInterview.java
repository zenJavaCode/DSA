package streams;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class EYInterview {


    public static void main(String[] args) {
        String original = "radar";
        char[] strArray = original.toCharArray();
        int low = 0;
        int high = strArray.length-1;
        boolean isPalindrome = true;
        while(low<=high){
            if(strArray[low] != strArray[high]){
                System.out.println("Not a palindrome");
                isPalindrome = false;
                break;
            }else{
                low++;
                high--;
            }
        }
        if(isPalindrome){
            System.out.println("String is A Palindrome.");
        }
    }


    static LinkedList<Integer> reverseALinkedList(LinkedList<Integer> head) {
        LinkedList<Integer> reversed = new LinkedList();
        Stack<Integer> stack = new Stack();
        Iterator<Integer> iterator = head.iterator();
        while (iterator.hasNext()) {
            stack.push(iterator.next());
        }
        while (!stack.isEmpty()) {
            reversed.add(stack.pop());
        }
        return reversed;
    }








}
