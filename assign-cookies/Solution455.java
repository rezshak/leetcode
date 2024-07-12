// https://leetcode.com/problems/assign-cookies/

import java.util.*;

class Solution455 {

    // T: O(nlogn), S: O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = 0, sIdx = 0, count = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (s[sIdx] >= g[gIdx]) {
                count++;
                sIdx++;
                gIdx++;
            } else {
                sIdx++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution455();
        var g1 = new int[] { 1, 2, 3 };
        var s1 = new int[] { 1, 1 };
        System.out.println(sol.findContentChildren(g1, s1)); // 1
        var g2 = new int[] { 1, 2 };
        var s2 = new int[] { 1, 2, 3 };
        System.out.println(sol.findContentChildren(g2, s2)); // 2
    }

}
