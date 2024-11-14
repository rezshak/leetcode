// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.util.Stack;

class Solution1249 {

    // T: O(n), S: O(n)
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        var st = new Stack<int[]>(); // ch, i
        var arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char ch = arr[i];
            if (!st.isEmpty() && st.peek()[0] == '(' && ch == ')') {
                st.pop();
            } else if (ch == '(' || ch == ')') {
                st.push(new int[] { ch, i });
            }
        }
        var sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (!st.isEmpty() && st.peek()[1] == i) {
                st.pop();
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var sol = new Solution1249();
        var s1 = "lee(t(c)o)de)";
        var s2 = "a)b(c)d";
        var s3 = "))((";
        System.out.println(sol.minRemoveToMakeValid(s1));
        System.out.println(sol.minRemoveToMakeValid(s2));
        System.out.println(sol.minRemoveToMakeValid(s3));
    }

}
