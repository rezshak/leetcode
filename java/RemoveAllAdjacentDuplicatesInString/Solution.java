// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

class Solution {

    // T: O(n), S: O(n)
    public String removeDuplicates(String str) {
        var stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
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

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = "abbaca";
        System.out.println(sol.removeDuplicates(s1)); // "ca"
        var s2 = "azxxzy";
        System.out.println(sol.removeDuplicates(s2)); // "ay"
    }

}
