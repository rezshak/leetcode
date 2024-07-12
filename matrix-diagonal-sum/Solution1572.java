// https://leetcode.com/problems/matrix-diagonal-sum/

class Solution1572 {

    // T: O(n), S: O(1)
    public int diagonalSum(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int sum = 0;
        for (int r = 0, c = 0; r < rows && c < cols; r++, c++) {
            sum += mat[r][c];
        }
        for (int r = 0, c = cols - 1; r < rows && c >= 0; r++, c--) {
            sum += mat[r][c];
        }
        if (rows % 2 == 1) {
            sum -= mat[rows / 2][cols / 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        var sol = new Solution1572();
        var mat1 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(sol.diagonalSum(mat1)); // 25
        var mat2 = new int[][] {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };
        System.out.println(sol.diagonalSum(mat2)); // 8
    }

}
