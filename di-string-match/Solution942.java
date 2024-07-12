// https://leetcode.com/problems/di-string-match/

import java.util.Arrays;

class Solution942 {

    // T: O(n), S: O(n)
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        var perm = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                perm[i] = low;
                low++;
            } else {
                perm[i] = high;
                high--;
            }
        }
        perm[n] = low; // or high, since low == high at this point
        return perm;
    }

    public static void main(String[] args) {
        var sol = new Solution942();
        var s1 = "IDID";
        var s2 = "III";
        var s3 = "DDI";
        System.out.println(Arrays.toString(sol.diStringMatch(s1))); // [0,4,1,3,2]
        System.out.println(Arrays.toString(sol.diStringMatch(s2))); // [0,1,2,3]
        System.out.println(Arrays.toString(sol.diStringMatch(s3))); // [3,2,0,1]
    }

}
