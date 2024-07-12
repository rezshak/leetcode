// https://leetcode.com/problems/valid-palindrome-ii/

class Solution680 {

    // T: O(n), S:(1)
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return palindromeHelper(s, left, right - 1) ||
                        palindromeHelper(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean palindromeHelper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution680();
        var s1 = "aba";
        var s2 = "abca";
        var s3 = "abc";
        System.out.println(sol.validPalindrome(s1)); // true
        System.out.println(sol.validPalindrome(s2)); // true
        System.out.println(sol.validPalindrome(s3)); // false
    }

}
