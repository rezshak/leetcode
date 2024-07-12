// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

import java.util.Arrays;

class Solution1790 {

    // T: O(n), S: O(1)
    public boolean areAlmostEqual(String s1, String s2) {
        var counts1 = new int[26];
        var counts2 = new int[26];
        int diffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs++;
            }
            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
        }
        if (!Arrays.equals(counts1, counts2)) {
            return false;
        }
        return diffs == 2 || diffs == 0;
    }

    public static void main(String[] args) {
        var sol = new Solution1790();
        System.out.println(sol.areAlmostEqual("bank", "kanb")); // true
        System.out.println(sol.areAlmostEqual("attack", "defend")); // false
        System.out.println(sol.areAlmostEqual("kelb", "kelb")); // true
        System.out.println(sol.areAlmostEqual("caa", "aaz")); // false
    }

}
