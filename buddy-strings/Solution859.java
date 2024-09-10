// https://leetcode.com/problems/buddy-strings/

import java.util.Arrays;

class Solution859 {

    // T: O(n), S: O(1)
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // Edge case
        if (s.equals(goal)) {
            var counts = new int[26];
            for (char ch : s.toCharArray()) {
                counts[ch - 'a']++;
                if (counts[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        int n = s.length(), diffCount = 0;
        int[] sCounts = new int[26], gCounts = new int[26];
        for (int i = 0; i < n; i++) {
            sCounts[s.charAt(i) - 'a']++;
            gCounts[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
            }
        }
        return diffCount == 2 && Arrays.equals(sCounts, gCounts);
    }

    public static void main(String[] args) {
        var sol = new Solution859();
        System.out.println(sol.buddyStrings("ab", "ba")); // true
        System.out.println(sol.buddyStrings("ab", "ab")); // false
        System.out.println(sol.buddyStrings("aa", "aa")); // true
    }

}
