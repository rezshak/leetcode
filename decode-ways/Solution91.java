// https://leetcode.com/problems/decode-ways/

import java.util.*;

class Solution91 {

    // T: O(2^n), S: O(n)
    public int numDecodingsRec(String s) {
        return dfsRec(0, s);
    }

    // T: O(2^n), S: O(n)
    private int dfsRec(int i, String s) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfsRec(i + 1, s);
        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += dfsRec(i + 2, s);
            }
        }
        return res;
    }

    // T: O(n), S: O(n)
    public int numDecodingsDpTopDown(String s) {
        var dp = new HashMap<Integer, Integer>();
        dp.put(s.length(), 1);

        return dfsDp(s, 0, dp);
    }

    // T: O(n), S: O(n)
    private int dfsDp(String s, int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfsDp(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfsDp(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }

    // T: O(n), S: O(n)
    public int numDecodingsDpBottomUp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                        s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    // T: O(n), S: O(1)
    public int numDecodingsDpBottomUpOpt(String s) {
        int dp = 0, dp2 = 0;
        int dp1 = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp = 0;
            } else {
                dp = dp1;
                if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                        s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }
        return dp1;
    }

    public static void main(String[] args) {
        var sol = new Solution91();
        var s1 = "12";
        System.out.println(sol.numDecodingsDpTopDown(s1)); // 2
        System.out.println(sol.numDecodingsRec(s1)); // 2
        System.out.println(sol.numDecodingsDpBottomUp(s1)); // 2
        System.out.println(sol.numDecodingsDpBottomUpOpt(s1)); // 2
        var s2 = "226";
        System.out.println(sol.numDecodingsDpTopDown(s2)); // 3
        System.out.println(sol.numDecodingsRec(s2)); // 3
        System.out.println(sol.numDecodingsDpBottomUp(s2)); // 3
        System.out.println(sol.numDecodingsDpBottomUpOpt(s2)); // 3
        var s3 = "06";
        System.out.println(sol.numDecodingsDpTopDown(s3)); // 0
        System.out.println(sol.numDecodingsRec(s3)); // 0
        System.out.println(sol.numDecodingsDpBottomUp(s3)); // 0
        System.out.println(sol.numDecodingsDpBottomUpOpt(s3)); // 0
    }

}
