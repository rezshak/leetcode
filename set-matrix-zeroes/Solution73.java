// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.Arrays;

class Solution73 {

    // T: O(m*n), S: (m+n)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        var rowsToSet = new boolean[rows];
        var colsToSet = new boolean[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    rowsToSet[row] = true;
                    colsToSet[col] = true;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            if (rowsToSet[r]) {
                resetRow(matrix, r);
            }
        }
        for (int c = 0; c < cols; c++) {
            if (colsToSet[c]) {
                resetCol(matrix, c);
            }
        }
    }

    // T: O(m*n), S: O(1)
    public void setZeroesOpt(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                resetRow(matrix, row);
            }
        }
        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                resetCol(matrix, col);
            }
        }
        if (firstRowHasZero) {
            resetRow(matrix, 0);
        }
        if (firstColHasZero) {
            resetCol(matrix, 0);
        }
    }

    private void resetRow(int[][] matrix, int rowIdx) {
        int cols = matrix[0].length;
        for (int c = 0; c < cols; c++) {
            matrix[rowIdx][c] = 0;
        }
    }

    private void resetCol(int[][] matrix, int colIdx) {
        int rows = matrix.length;
        for (int r = 0; r < rows; r++) {
            matrix[r][colIdx] = 0;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution73();
        var matrix1 = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        var matrix2 = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        sol.setZeroes(matrix1);
        sol.setZeroesOpt(matrix2);
        System.out.println(Arrays.deepToString(matrix1)); // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
        System.out.println(Arrays.deepToString(matrix2)); // [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }

}
