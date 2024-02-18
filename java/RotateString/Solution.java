// https://leetcode.com/problems/rotate-string/

public class Solution {

    // T: O(n), S: O(n)
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        var s2 = s + s;
        return s2.contains(goal);
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab")); // true
        System.out.println(sol.rotateString("abcde", "abced")); // false
    }

}
