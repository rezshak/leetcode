// https://leetcode.com/problems/palindromic-substrings/

class Solution647 {

    // Two pointer, expand around center
    // T: O(n^2), S: O(1)
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i + 1);
        }
        return res;
    }

    // T: O(n), S: O(1)
    private int countPalindrome(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }

    // T: O(n^2), S: O(n^2)
    public int countSubstringsDp(String s) {
        int res = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    // T: O(n^3), S: O(1)
    public int countSubstringsBrute(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int l = i, r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }
                res += (l >= r) ? 1 : 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution647();
        var s1 = "abc";
        var s2 = "aaa";
        System.out.println(sol.countSubstrings(s1)); // 3
        System.out.println(sol.countSubstringsBrute(s1)); // 3
        System.out.println(sol.countSubstringsDp(s1)); // 3
        System.out.println(sol.countSubstrings(s2)); // 6
        System.out.println(sol.countSubstringsDp(s2)); // 6
        System.out.println(sol.countSubstringsBrute(s2)); // 6
    }

}
