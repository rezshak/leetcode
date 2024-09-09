// https://leetcode.com/problems/matrix-diagonal-sum/

class Solution1572 {

    // T: O(n), S: O(1)
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int diagSum = 0, antiDiagSum = 0;
        for (int i = 0; i < n; i++) {
            diagSum += mat[i][i];
            if (i != n - 1 - i) {
                antiDiagSum += mat[i][n - i - 1];
            }
        }
        return diagSum + antiDiagSum;
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
