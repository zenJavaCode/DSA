package stack;

public class StacksUsingArray {
    int[] arr = new int[10000];
    int top = -1;

    int push(int data) {
        if (top == 999) {
            return -1;
        }
        top++;
        arr[top] = data;
        return top;
    }

    int pop() {
        if (top == -1) {
            return -1;
        }
        int x = arr[top];
        top--;
        return x;
    }

    int peek() {
        if (top == -1) {
            return -1;
        }
        return arr[top];
    }

}
