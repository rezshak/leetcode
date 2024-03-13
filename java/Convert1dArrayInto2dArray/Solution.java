// https://leetcode.com/problems/convert-1d-array-into-2d-array/

package Convert1dArrayInto2dArray;

import java.util.Arrays;

class Solution {

    // T: O(mn), S: (mn)
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][] {};
        }
        int[][] result = new int[m][n];
        for (int i = 0, k = 0; i < m && k < original.length; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[k++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 1, 2, 3, 4 };
        var nums2 = new int[] { 1, 2, 3 };
        var nums3 = new int[] { 1, 2 };
        System.out.println(Arrays.deepToString(sol.construct2DArray(nums1, 2, 2))); // [[1,2],[3,4]]
        System.out.println(Arrays.deepToString(sol.construct2DArray(nums2, 1, 3))); // [[1,2,3]]
        System.out.println(Arrays.deepToString(sol.construct2DArray(nums3, 1, 1))); // []
    }

}
