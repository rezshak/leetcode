// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.HashSet;

class Solution3 {

    // T: O(n), S: O(k) where k is the unique characters in the string
    public int lengthOfLongestSubstring(String s) {
        var seen = new HashSet<Character>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()) {
            if (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            } else {
                seen.add(s.charAt(right));
                right++;
                result = Math.max(result, right - left);
            }
        }
        return result;
    }

    // T: O(n), S: O(k)
    public int lengthOfLongestSubstringOpt(String s) {
        var indices = new HashMap<Character, Integer>();
        int result = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            // If the character is already in the current window,
            // move the start pointer to the right of its previous occurrence
            if (indices.containsKey(curr) && indices.get(curr) >= left) {
                left = indices.get(curr) + 1;
            }

            // Update the most recent index of the current character
            indices.put(curr, right);

            // Update the maximum length if the current window is longer
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution3();
        var s1 = "abcabcbb";
        var s2 = "bbbbb";
        var s3 = "pwwkew";
        var s4 = "aab";
        System.out.println(sol.lengthOfLongestSubstring(s1)); // 3
        System.out.println(sol.lengthOfLongestSubstringOpt(s1)); // 3
        System.out.println(sol.lengthOfLongestSubstring(s2)); // 1
        System.out.println(sol.lengthOfLongestSubstringOpt(s2)); // 1
        System.out.println(sol.lengthOfLongestSubstring(s3)); // 3
        System.out.println(sol.lengthOfLongestSubstringOpt(s3)); // 3
        System.out.println(sol.lengthOfLongestSubstring(s4)); // 2
        System.out.println(sol.lengthOfLongestSubstringOpt(s4)); // 2
    }

}
