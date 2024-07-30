// https://leetcode.com/problems/plus-one/

import java.util.*;

class Solution66 {

    // T: O(n), S: O(n)
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        var result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution66();
        var digits1 = new int[] { 1, 2, 3 };
        var digits2 = new int[] { 4, 3, 2, 1 };
        var digits3 = new int[] { 9 };
        System.out.println(Arrays.toString(sol.plusOne(digits1))); // [1,2,4]
        System.out.println(Arrays.toString(sol.plusOne(digits2))); // [4,3,2,2]
        System.out.println(Arrays.toString(sol.plusOne(digits3))); // [1,0]
    }

}
