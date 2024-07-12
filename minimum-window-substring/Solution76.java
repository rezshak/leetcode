// https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

class Solution76 {

    // T: O(n+m), S: O(m)
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        var tFreq = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            tFreq.put(ch, tFreq.getOrDefault(ch, 0) + 1);
        }

        int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            if (tFreq.containsKey(rChar)) {
                tFreq.put(rChar, tFreq.get(rChar) - 1);
                if (tFreq.get(rChar) >= 0) {
                    count++;
                }
            }
            // Valid window found, shrink it
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }

                char lChar = s.charAt(left);
                if (tFreq.containsKey(lChar)) {
                    tFreq.put(lChar, tFreq.get(lChar) + 1);
                    if (tFreq.get(lChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
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
