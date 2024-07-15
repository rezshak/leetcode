// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;

class Solution3 {

    // T: O(n), S: O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
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
