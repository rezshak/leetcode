// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

class Solution1252 {

    // T: O(mn), S: O(mn)
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int r = 0; r < indices.length; r++) {
            int row = indices[r][0];
            int col = indices[r][1];
            incrementRow(arr, row);
            incrementCol(arr, col);
        }
        int count = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void incrementRow(int[][] arr, int row) {
        for (int c = 0; c < arr[row].length; c++) {
            arr[row][c]++;
        }
    }

    private void incrementCol(int[][] arr, int col) {
        for (int r = 0; r < arr.length; r++) {
            arr[r][col]++;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution1252();
        var indices1 = new int[][] { { 0, 1 }, { 1, 1 } };
        var indices2 = new int[][] { { 1, 1 }, { 0, 0 } };
        System.out.println(sol.oddCells(2, 3, indices1)); // 6
        System.out.println(sol.oddCells(2, 2, indices2)); // 0
    }

}
