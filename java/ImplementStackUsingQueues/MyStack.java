// https://leetcode.com/problems/implement-stack-using-queues/

package ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = 0;
    }

    // T: O(1), S: O(n)
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // T: O(n), S: O(n)
    public int pop() {
        while (q1.size() != 1) {
            top = q1.remove();
            q2.add(top);
        }
        int val = q1.remove();
        var tmp = q1;
        q1 = q2;
        q2 = tmp;
        return val;
    }

    // T: O(1), S: O(1)
    public int top() {
        return top;
    }

    // T: O(1), S: O(1)
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }

    public static void main(String[] args) {
        var st = new MyStack();
        st.push(1);
        st.push(2);
        System.out.println(st.top()); // 2
        System.out.println(st.pop()); // 2
        System.out.println(st.empty()); // false
    }

}
