// https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

class Solution76 {

    // # T: O(n), S: O(k)
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        var tCounts = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            tCounts.put(ch, tCounts.getOrDefault(ch, 0) + 1);
        }
        int required = tCounts.size();

        int minLeft = 0, minRight = 0, minWinLen = Integer.MAX_VALUE;

        // Keep track of how many unique characters in t are present
        // in the current window in its desired frequency
        int formed = 0;

        var winCounts = new HashMap<Character, Integer>();

        for (int left = 0, right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            winCounts.put(rightChar, winCounts.getOrDefault(rightChar, 0) + 1);

            if (tCounts.containsKey(rightChar)
                    && winCounts.get(rightChar).intValue() == tCounts.get(rightChar).intValue()) {
                formed++;
            }
            // Shrink the window till the point where it ceases to be formed
            while (left <= right && formed == required) {
                int currWinLen = right - left + 1;
                if (currWinLen < minWinLen) {
                    minWinLen = currWinLen;
                    minLeft = left;
                    minRight = right;
                }
                // Left char no longer part of the window
                char leftChar = s.charAt(left);
                winCounts.put(leftChar, winCounts.get(leftChar) - 1);
                // If the frequency of the current character becomes less than the desired count
                // decrement formed
                if (tCounts.containsKey(leftChar)
                        && winCounts.get(leftChar).intValue() < tCounts.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }

        return minWinLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        var sol = new Solution76();
        var s1 = "ADOBECODEBANC";
        var t1 = "ABC";
        System.out.println(sol.minWindow(s1, t1)); // "BANC"
        var s2 = "a";
        var t2 = "a";
        System.out.println(sol.minWindow(s2, t2)); // "a"
        var s3 = "a";
        var t3 = "aa";
        System.out.println(sol.minWindow(s3, t3)); // ""
    }

}
