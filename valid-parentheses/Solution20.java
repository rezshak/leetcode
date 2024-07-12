// https://leetcode.com/problems/valid-parentheses/

import java.util.*;

class Solution20 {

    private static final Set<Character> OPEN_SYMS = Set.of(
            '{', '[', '(');
    private static final Map<Character, Character> CLOSE_SYMS = Map.of(
            '}', '{',
            ']', '[',
            ')', '(');

    // T: O(n), S: O(n)
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (OPEN_SYMS.contains(ch)) {
                stack.push(ch);
            } else if (CLOSE_SYMS.containsKey(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (CLOSE_SYMS.get(ch) != top) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        var sol = new Solution20();
        var s1 = "()";
        var s2 = "()[]{}";
        var s3 = "(]";
        System.out.println(sol.isValid(s1)); // true
        System.out.println(sol.isValid(s2)); // true
        System.out.println(sol.isValid(s3)); // false
    }

}
