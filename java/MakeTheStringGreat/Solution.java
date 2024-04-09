// https://leetcode.com/problems/make-the-string-great/

package MakeTheStringGreat;

import java.util.Stack;

class Solution {

    // T: O(n), S: O(n)
    public String makeGood(String str) {
        var stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!stack.isEmpty() && areSameCharsDiffCases(ch, stack.peek())) {
                stack.pop();
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

    private boolean areSameCharsDiffCases(char ch1, char ch2) {
        if (ch1 == ch2) {
            return false;
        }
        if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = "leEeetcode";
        System.out.println(sol.makeGood(s1)); // "leetcode"
        var s2 = "abBAcC";
        System.out.println(sol.makeGood(s2)); // ""
        var s3 = "s";
        System.out.println(sol.makeGood(s3)); // "s"
    }

}
