// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

class Solution2108 {

    // T: O(nm), S: O(1)
    public String firstPalindrome(String[] words) {
        for (var w : words) {
            if (isPalindrome(w)) {
                return w;
            }
        }
        return "";
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
        var sol = new Solution2108();
        var words1 = new String[] { "abc", "car", "ada", "racecar", "cool" };
        var words2 = new String[] { "notapalindrome", "racecar" };
        var words3 = new String[] { "def", "ghi" };
        System.out.println(sol.firstPalindrome(words1)); // "ada"
        System.out.println(sol.firstPalindrome(words2)); // "racecar"
        System.out.println(sol.firstPalindrome(words3)); // ""
    }

}
