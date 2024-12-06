// https://leetcode.com/problems/longest-palindromic-substring/

class Solution5 {

    // Two pointer, expand around the center
    // T: O(n^2), S: O(1)
    public String longestPalindrome(String s) {
        int resLen = 0, resIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
            // Even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resIdx = l;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    // T: O(n^2), S: O(1)
    public String longestPalindromeBetterBrute(String s) {
        var res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int l = i, r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                if (l >= r && resLen < (j - i + 1)) {
                    res = s.substring(i, j + 1);
                    resLen = j - i + 1;
                }
            }
        }

        return res;
    }

    // T: O(n^2), S: O(n^2)
    public String longestPalindromeDp(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    // T: O(n^3), S: O(1)
    public String longestPalindromeBrute(String s) {
        var res = "";
        var resLen = 0;
        for (var i = 0; i < s.length(); i++) {
            for (var j = i; j < s.length(); j++) {
                var substr = s.substring(i, j + 1);
                if (isPalindrome(substr) && substr.length() > resLen) {
                    res = substr;
                    resLen = substr.length();
                }
            }
        }
        return res;
    }

    // T: O(k), S: O(1)
    private boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution5();
        var s1 = "babad";
        var s2 = "cbbd";
        var s3 = "a";
        System.out.println(sol.longestPalindrome(s1)); // "cbbd"
        System.out.println(sol.longestPalindromeBrute(s1)); // "cbbd"
        System.out.println(sol.longestPalindromeBetterBrute(s1)); // "cbbd"
        System.out.println(sol.longestPalindrome(s2)); // "bb"
        System.out.println(sol.longestPalindromeBrute(s2)); // "bb"
        System.out.println(sol.longestPalindromeBetterBrute(s2)); // "bb"
        System.out.println(sol.longestPalindrome(s3)); // "a"
        System.out.println(sol.longestPalindromeBrute(s3)); // "a"
        System.out.println(sol.longestPalindromeBetterBrute(s3)); // "a"
    }

}
