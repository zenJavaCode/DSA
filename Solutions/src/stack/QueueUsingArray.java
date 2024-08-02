package stack;

public class QueueUsingArray {

    int[] arr;
    int start , currSize , end , maxSize;

    public QueueUsingArray() {
        arr = new int[16];
        start = -1;
        currSize = 0;
        end = -1;
    }

    public QueueUsingArray(int capacity) {
        this.maxSize = capacity;
        arr = new int[capacity];
        start = -1;
        end = -1;
        currSize =0;
    }

    public void push(int item) {
        if (currSize == maxSize) {
            System.out.println("Queue is full");
            System.exit(1);
        }
        if(end == -1) {
            start = 0;
            end =0;

        }else{
            end = (end +1) % maxSize;
            arr[end] = item;
            System.out.println("The element pushed is " + item);
            currSize++;
        }
    }
    public int pop() {
        if(start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];
        if (currSize == 1) {
        start = -1;
        end = -1;

        }else{
            start = (start + 1) % maxSize;
            currSize--;

        }
        return popped;
        }




}
