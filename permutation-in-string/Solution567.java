// https://leetcode.com/problems/permutation-in-string/

import java.util.*;

class Solution567 {

    // T: O(n), S: O(1)
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        var counts1 = new int[26];
        var counts2 = new int[26];
        for (int i = 0; i < n1; i++) {
            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
        }
        for (int i = n1; i < n2; i++) {
            if (Arrays.equals(counts1, counts2)) {
                return true;
            }
            counts2[s2.charAt(i - n1) - 'a']--;
            counts2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(counts1, counts2);
    }

    public static void main(String[] args) {
        var sol = new Solution567();
        System.out.println(sol.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(sol.checkInclusion("ab", "eidboaoo")); // false
        System.out.println(sol.checkInclusion("adc", "dcda")); // true
    }

}
