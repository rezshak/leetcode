// https://leetcode.com/problems/spiral-matrix/

import java.util.*;

class Solution54 {

    // T: O(m*n), S: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        var result = new ArrayList<Integer>();
        while (left <= right && top <= bottom) {
            // Traverse left -> right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;
            // Traverse top -> bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            if (top <= bottom) {
                // Traverse right -> left
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            if (left <= right) {
                // Traverse bottom -> top
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution54();
        var matrix1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        var matrix2 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        var matrix3 = new int[][] { { 1, 2, 3, 4 } };
        System.out.println(sol.spiralOrder(matrix1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(sol.spiralOrder(matrix2)); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        System.out.println(sol.spiralOrder(matrix3)); // [1, 2, 3, 4]
    }

}