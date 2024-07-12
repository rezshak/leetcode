// https://leetcode.com/problems/reverse-string/

import java.util.Arrays;
import java.util.Stack;

class Solution344 {

    // T: O(n), S: O(1)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // T: O(n), S: O(n)
    public void reverseStringStack(char[] s) {
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        var sol = new Solution344();
        var s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        sol.reverseString(s1);
        System.out.println(Arrays.toString(s1)); // [o, l, l, e, h]
        var s2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        sol.reverseStringStack(s2);
        System.out.println(Arrays.toString(s2)); // [h, a, n, n, a, H]
    }

}
