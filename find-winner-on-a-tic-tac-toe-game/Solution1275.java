// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

class Solution1275 {

    private static final int N = 3; // NxN board

    // T: O(m), S: O(1)
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        // Row, column, and diagonal sums
        var rows = new int[N];
        var cols = new int[N];
        int diag = 0;
        int antiDiag = 0;
        int player = 1;
        for (int i = 0; i < n; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            rows[row] += player;
            cols[col] += player;
            if (row == col) {
                diag += player;
            }
            if (row + col == N - 1) {
                antiDiag += player;
            }
            if (Math.abs(rows[row]) == N || Math.abs(cols[col]) == N ||
                    Math.abs(diag) == N || Math.abs(antiDiag) == N) {
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }

        return n == N * N ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        var sol = new Solution1275();
        var moves1 = new int[][] { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
        var moves2 = new int[][] { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
        System.out.println(sol.tictactoe(moves1)); // A
        System.out.println(sol.tictactoe(moves2)); // B
    }

}
