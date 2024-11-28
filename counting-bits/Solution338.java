// https://leetcode.com/problems/counting-bits/

import java.util.*;

class Solution338 {

    // T: O(nlogn), S: O(n)
    public int[] countBits(int n) {
        var ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = count1Bits(i);
        }
        return ans;
    }

    private int count1Bits(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution338();
        System.out.println(Arrays.toString(sol.countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(sol.countBits(5))); // [0,1,1,2,1,2]
    }

}
