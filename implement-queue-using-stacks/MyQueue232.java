// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue232 {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // T: O(n), S: O(n)
    public void push(int x) {
        s1.push(x);
    }

    // T: O(1), S: O(1)
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // T: O(1), S: O(1)
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // T: O(1), S: O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        var mq = new MyQueue232();
        mq.push(1);
        mq.push(2);
        System.out.println(mq.peek()); // 1
        System.out.println(mq.pop()); // 1
        System.out.println(mq.empty()); // false
    }

}
