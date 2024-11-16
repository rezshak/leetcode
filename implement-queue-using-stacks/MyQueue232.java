// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue232 {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue232() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // T: O(n), S: O(n)
    public void push(int x) {
        st1.push(x);
    }

    // T: O(1), S: O(1)
    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    // T: O(1), S: O(1)
    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    // T: O(1), S: O(1)
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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
