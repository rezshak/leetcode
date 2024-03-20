// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.ArrayDeque;

class MyStack {

    private ArrayDeque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    // T: O(1), S: O(n)
    public void push(int x) {
        queue.addLast(x);
    }

    // T: O(1), S: O(1)
    public int pop() {
        return queue.removeLast();
    }

    // T: O(1), S: O(1)
    public int top() {
        return queue.peekLast();
    }

    // T: O(1), S: O(1)
    public boolean empty() {
        return queue.size() == 0;
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
