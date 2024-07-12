// https://leetcode.com/problems/remove-palindromic-subsequences/

class Solution1332 {

    // T: O(n), S: O(1)
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution1332();
        var s1 = "ababa";
        var s2 = "abb";
        var s3 = "baabb";
        System.out.println(sol.removePalindromeSub(s1)); // 1
        System.out.println(sol.removePalindromeSub(s2)); // 2
        System.out.println(sol.removePalindromeSub(s3)); // 2
    }

}
