package linkedList;

import java.util.Stack;

public class NodeDriver {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node node = constructLL(arr);
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    static Node constructLL(int arr[]) {
        // code here

        if (arr == null || arr.length == 0)
            return null;

        // Create the first node with the value of the first element in the array
        Node head = new Node(arr[0]);
        Node tail = head; // Track the tail of the linked list

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Create a new node with the value of the current element
            Node newNode = new Node(arr[i]);
            // Link the new node to the current tail
            tail.next = newNode;
            // Update the tail to be the newly added node
            tail = newNode;
        }


        return head; // Return the
    }


    static Node insertAtBeginning(Node head, int x) {
        // code here

        Node headNode = new Node(x);
        headNode.next = head;
        return headNode;

    }

    //Function to insert a node at the end of the linked list.
    static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the new node
        current.next = newNode;

        // Return the head (unchanged in this case)
        return head;
        // code here
    }

    /*TODO Problem Statement: Given a linked list, delete the tail of the linked
        list and print the updated linked list.*/
    public Node deleteNode(Node node) {
        if (node == null || node.next == null) { // Handle empty list or single-node list
            return null;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        return node;
    }


//    public Node deleteNodeAtKthPosition(Node node,int k) {
//        if (node == null || node.next == null) { // Handle empty list or single-node list
//            return null;
//        }
//        return null;
//    }


    public Node middleNode(Node head) {

        int count = 1;
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        for (int i = 0; i < mid; i++) {
            head = head.next;
        }
        return head;


    }

    public Node middleNodeHereAndTortoiseMethod(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = head.next.next;
            slow = head.next;
        }
        return slow;


    }


    /*TODO Reverse a LinkedList*/

//    public Node reverseLinkedList(Node head) {
//
//        Node temp = head;
//
//        Stack<Integer> stack = new Stack<>();
//        while(temp.next != null){
//
//
//            stack.push(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//
//        while(temp !=null){
//            temp.data =
//        }
//
//        return head;
//    }
}
