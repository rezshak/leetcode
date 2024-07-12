// https://leetcode.com/problems/shortest-distance-to-a-character/

import java.util.Arrays;

class Solution821 {

    // T: O(n), S: O(n)
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        var ans = new int[n];
        int dist = n;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                dist = 0;
            } else {
                dist++;
            }
            ans[i] = dist;
        }
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == c) {
                dist = 0;
            } else {
                dist++;
            }
            ans[i] = Math.min(ans[i], dist);
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution821();
        var s1 = "loveleetcode";
        var s2 = "aaab";
        System.out.println(Arrays.toString(sol.shortestToChar(s1, 'e'))); // [3,2,1,0,1,0,0,1,2,2,1,0]
        System.out.println(Arrays.toString(sol.shortestToChar(s2, 'b'))); // [3,2,1,0]
    }

}
