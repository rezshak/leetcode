// https://leetcode.com/problems/removing-stars-from-a-string/

package RemovingStarsFromAString;

import java.util.Stack;

class Solution {

    // T: O(n), S: O(n)
    public String removeStars(String s) {
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*' && !stack.isEmpty()) {
                stack.pop();
            } else if (ch != '*') {
                stack.push(ch);
            }
        }
        return stackToString(stack);
    }

    private String stackToString(Stack<Character> stack) {
        var strArr = new char[stack.size()];
        for (int i = strArr.length - 1; i >= 0; i--) {
            strArr[i] = stack.pop();
        }
        return new String(strArr);
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = "leet**cod*e";
        var s2 = "erase*****";
        System.out.println(sol.removeStars(s1)); // "lecoe"
        System.out.println(sol.removeStars(s2)); // ""
    }

}
