// https://leetcode.com/problems/removing-stars-from-a-string/

import java.util.Stack;

class Solution2390 {

    // T: O(n), S: O(n)
    public String removeStars(String str) {
        var stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        var sb = new StringBuilder();
        for (var ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution2390();
        var s1 = "leet**cod*e";
        var s2 = "erase*****";
        System.out.println(sol.removeStars(s1)); // "lecoe"
        System.out.println(sol.removeStars(s2)); // ""
    }

}
