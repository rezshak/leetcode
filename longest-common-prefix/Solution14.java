// https://leetcode.com/problems/longest-common-prefix/

import java.util.Arrays;

class Solution14 {

    // T: O(S) where S is sum of all characters, S: O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();
        for (var str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        var sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (var str : strs) {
                if (str.charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    // T: O(S) where S is sum of all characters, S: O(1)
    public String longestCommonPrefixOpt1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        var sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (var str : strs) {
                if (i > str.length() - 1 || str.charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    // T: O(n*log(n)) for sorting + O(m) for comparison, where:
    // n = number of strings, m = length of shortest string between first/last
    // S: O(1) since Arrays.sort uses QuickSort/DualPivotQuickSort
    public String longestCommonPrefixOpt2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);

        var first = strs[0];
        var last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

    public static void main(String[] args) {
        var sol = new Solution14();
        var strs1 = new String[] { "flower", "flow", "flight" };
        var strs2 = new String[] { "dog", "racecar", "car" };
        var strs3 = new String[] { "a" };
        System.out.println(sol.longestCommonPrefix(strs1)); // fl
        System.out.println(sol.longestCommonPrefix(strs2)); // ""
        System.out.println(sol.longestCommonPrefix(strs3)); // a
        System.out.println(sol.longestCommonPrefixOpt1(strs1)); // fl
        System.out.println(sol.longestCommonPrefixOpt1(strs2)); // ""
        System.out.println(sol.longestCommonPrefixOpt1(strs3)); // a
        System.out.println(sol.longestCommonPrefixOpt2(strs1)); // fl
        System.out.println(sol.longestCommonPrefixOpt2(strs2)); // ""
        System.out.println(sol.longestCommonPrefixOpt2(strs3)); // a
    }

}
