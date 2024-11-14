// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

import java.util.Stack;

class Solution1047 {

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

    // T: O(n), S: O(n)
    public String removeDuplicates2(String s) {
        var st = new StringBuilder(); // Use sb as stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int len = st.length();
            if (len > 0 && st.charAt(len - 1) == ch) {
                st.deleteCharAt(len - 1);
            } else {
                st.append(ch);
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution1047();
        var s1 = "abbaca";
        var s2 = "azxxzy";
        System.out.println(sol.removeDuplicates(s1)); // "ca"
        System.out.println(sol.removeDuplicates2(s1)); // "ca"
        System.out.println(sol.removeDuplicates(s2)); // "ay"
        System.out.println(sol.removeDuplicates2(s2)); // "ay"
    }

}
