// https://leetcode.com/problems/valid-palindrome/

package ValidPalindrome;

public class Solution {

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

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = "A man, a plan, a canal: Panama"; // true
        var s2 = "race a car"; // false
        System.out.println(sol.isPalindrome(s1));
        System.out.println(sol.isPalindrome(s2));
    }

}
