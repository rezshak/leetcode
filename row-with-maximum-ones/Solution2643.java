// https://leetcode.com/problems/row-with-maximum-ones/

import java.util.Arrays;

class Solution2643 {

    // T: O(mn), S: O(1)
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int onesCount = getOnesCount(row);
            if (onesCount > maxOnesCount) {
                maxOnesCount = onesCount;
                maxOnesIdx = i;
            }
        }
        return new int[] { maxOnesIdx, maxOnesCount };
    }

    private int getOnesCount(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution2643();
        var mat1 = new int[][] {
                { 1, 0 },
                { 0, 1 }
        };
        System.out.println(Arrays.toString(sol.rowAndMaximumOnes(mat1))); // [0,1]
        var mat2 = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 1 }
        };
        System.out.println(Arrays.toString(sol.rowAndMaximumOnes(mat2))); // [1,2]
    }

}
