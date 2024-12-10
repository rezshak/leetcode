// https://leetcode.com/problems/rotate-image/

class Solution48 {

    // T: O(n^2), S: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose (swap rows and cols) the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // System.out.println("Transposed:");
        // printMatrix(matrix);

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // T: O(n^2), S: O(n)
    public void rotateBrute(int[][] matrix) {
        int n = matrix.length;
        int[][] orig = new int[n][];
        for (int i = 0; i < n; i++) {
            orig[i] = matrix[i].clone();
        }
        for (int r = 0; r < n; r++) {
            int[] nums = orig[r];
            copyRowToCol(matrix, nums, n - r - 1);
        }
    }

    private void copyRowToCol(int[][] matrix, int[] nums, int col) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            matrix[i][col] = nums[i];
        }
    }

    // Helper method to print the matrix
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        var sol = new Solution48();

        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Original:");
        sol.printMatrix(matrix1);
        sol.rotate(matrix1);
        System.out.println("Rotated:");
        sol.printMatrix(matrix1);

        int[][] matrix2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        System.out.println("Original:");
        sol.printMatrix(matrix2);
        sol.rotate(matrix2);
        System.out.println("Rotated:");
        sol.printMatrix(matrix2);

        int[][] matrix3 = {
                { 1, 2 },
                { 3, 4 },
        };
        System.out.println("Original:");
        sol.printMatrix(matrix3);
        sol.rotate(matrix3);
        System.out.println("Rotated:");
        sol.printMatrix(matrix3);
    }

}
