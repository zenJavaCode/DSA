package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {


    Queue< Integer > q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        for(int i = 0;i<q.size();i++){
            q.add(q.remove());
        }
    }

    int pop() {
        return q.remove();
    }
    int top() {
        return q.peek();
    }
    int size() {
        return q.size();
    }
}
