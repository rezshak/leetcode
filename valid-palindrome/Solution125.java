// https://leetcode.com/problems/valid-palindrome/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution125 {

    // T: O(n), S: O(1)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            var leftChar = s.charAt(left);
            var rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // T: O(n), S: O(n)
    public boolean isPalindromeDeque(String s) {
        s = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            dq.addLast(ch);
        }
        while (dq.size() > 1) {
            char left = dq.removeFirst();
            char right = dq.removeLast();
            if (left != right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution125();
        var s1 = "A man, a plan, a canal: Panama"; // true
        var s2 = "race a car"; // false
        System.out.println(sol.isPalindrome(s1));
        System.out.println(sol.isPalindromeDeque(s1));
        System.out.println(sol.isPalindrome(s2));
        System.out.println(sol.isPalindromeDeque(s2));
    }

}
