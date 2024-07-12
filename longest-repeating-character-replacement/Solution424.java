// https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;

class Solution424 {

    // T: O(n), S: O(1)
    public int characterReplacement(String s, int k) {
        int result = 0, left = 0, mostFreqCount = 0;
        var counts = new HashMap<Character, Integer>();
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            counts.put(rightChar, counts.getOrDefault(rightChar, 0) + 1);
            mostFreqCount = Math.max(mostFreqCount, counts.get(rightChar));
            boolean validWindow = right - left + 1 - mostFreqCount <= k;
            if (!validWindow) {
                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.get(leftChar) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution424();
        var s1 = "ABAB";
        var s2 = "AABABBA";
        System.out.println(sol.characterReplacement(s1, 2)); // 4
        System.out.println(sol.characterReplacement(s2, 1)); // 4
    }

}
