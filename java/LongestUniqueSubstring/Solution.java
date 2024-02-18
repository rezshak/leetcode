// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package LongestUniqueSubstring;

import java.util.HashSet;

public class Solution {

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
        var s1 = "abcabcbb"; // 3
        var s2 = "bbbbb"; // 1
        var s3 = "pwwkew"; // 3
        var s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(s1));
        System.out.println(s.lengthOfLongestSubstring(s2));
        System.out.println(s.lengthOfLongestSubstring(s3));
    }

}
