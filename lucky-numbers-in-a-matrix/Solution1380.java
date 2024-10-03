// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

import java.util.ArrayList;
import java.util.List;

class Solution1380 {

    // T: O(m*n), S: O(m+n)
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        var rowsMin = new int[m];
        var colsMax = new int[n];
        for (int r = 0; r < m; r++) {
            rowsMin[r] = Integer.MAX_VALUE;
            for (int c = 0; c < n; c++) {
                rowsMin[r] = Math.min(rowsMin[r], matrix[r][c]);
            }
        }
        for (int c = 0; c < n; c++) {
            colsMax[c] = Integer.MIN_VALUE;
            for (int r = 0; r < m; r++) {
                colsMax[c] = Math.max(colsMax[c], matrix[r][c]);
            }
        }
        var result = new ArrayList<Integer>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int num = matrix[r][c];
                if (num == rowsMin[r] && num == colsMax[c]) {
                    result.add(num);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution1380();
        var matrix = new int[][] {
                { 3, 7, 8 },
                { 9, 11, 13 },
                { 15, 16, 17 }
        };
        var luckyNumbers = sol.luckyNumbers(matrix);
        System.out.println(luckyNumbers); // [15]
    }

}
