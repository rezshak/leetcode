// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;

class Solution3 {

    // T: O(n), S: O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        var seen = new HashSet<Character>();
        int n = s.length(), maxLen = 0;
        for (int l = 0, r = 0; r < n; r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var sol = new Solution3();
        var s1 = "abcabcbb";
        var s2 = "bbbbb";
        var s3 = "pwwkew";
        System.out.println(sol.lengthOfLongestSubstring(s1)); // 3
        System.out.println(sol.lengthOfLongestSubstring(s2)); // 1
        System.out.println(sol.lengthOfLongestSubstring(s3)); // 3
    }

}
