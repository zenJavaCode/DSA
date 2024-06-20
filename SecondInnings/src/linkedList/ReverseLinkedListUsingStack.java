
package linkedList;

import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;
    // Pointer to the next
    // node in the list
    Node next;

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(){

    }
}

public class ReverseLinkedListUsingStack {

    // Function to reverse the
    // linked list using a stack
    public static Node reverseLinkedList(Node head) {
        // Create a temporary pointer to
        // traverse the linked list
        Node temp = head;

        // Create a stack to temporarily
        //store the data values
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push the values of the
        // linked list onto the stack
        while (temp != null) {
            // Push the current node's
            // data onto the stack
            stack.push(temp.data);
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Reset the temporary pointer
        // to the head of the linked list
        temp = head;

        // Step 2: Pop values from the stack
        // and update the linked list
        while (temp != null) {
            // Set the current node's data
            // to the value at the top of the stack
            temp.data = stack.pop();
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Return the new head of
        // the reversed linked list
        return head;
    }

    // Function to print the linked list
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }

    /*TODO Reverse Using Iterative Approch*/

    public Node reverseUsingIterativeApproach(Node node){
        Node temp = node;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev =temp;
            temp = front;
        }
        return prev;
    }

    public Node reverseUsingRecursiveApproach(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node node = reverseUsingRecursiveApproach(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return node;
    }

    public static Boolean detectLoop(Node head) {
        Node temp =head;
        int count =0;
        Map<Node,Integer> map = new HashMap<>();
        while(temp !=null){
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }



}


