// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;

class Solution3 {

    // T: O(n), S: O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        var beg = 0;
        var end = 0;
        var max = 0;
        var set = new HashSet<Character>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            } else {
                set.remove(s.charAt(beg));
                beg++;
            }
            max = Math.max(max, end - beg);
        }
        return max;
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
