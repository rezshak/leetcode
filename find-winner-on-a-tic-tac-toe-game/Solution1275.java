// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

class Solution1275 {

    private static final int N = 3; // NxN board
    private static final int PLAYER1 = 1;
    private static final int PLAYER2 = -1;

    // T: O(m), S: O(1)
    public String tictactoe(int[][] moves) {
        var board = new int[N][N];
        boolean player1Turn = true;
        for (int i = 0; i < moves.length; i++) {
            int[] mv = moves[i];
            int x = mv[0], y = mv[1];
            if (player1Turn) {
                board[x][y] = PLAYER1;
                player1Turn = false;
            } else {
                board[x][y] = PLAYER2;
                player1Turn = true;
            }
        }
        // Check if a row is winner
        for (int r = 0; r < N; r++) {
            int rowSum = 0;
            for (int c = 0; c < N; c++) {
                rowSum += board[r][c];
            }
            if (rowSum == N) {
                return "A";
            } else if (rowSum == -N) {
                return "B";
            }
        }
        // Check if a col is winner
        for (int c = 0; c < N; c++) {
            int colSum = 0;
            for (int r = 0; r < N; r++) {
                colSum += board[r][c];
            }
            if (colSum == N) {
                return "A";
            } else if (colSum == -N) {
                return "B";
            }
        }
        // Check left-right and right-left diagonals
        int lrDiagSum = 0, rlDiagSum = 0;
        for (int i = 0; i < N; i++) {
            lrDiagSum += board[i][i];
            rlDiagSum += board[i][N - i - 1];
        }
        if (lrDiagSum == N || rlDiagSum == N) {
            return "A";
        } else if (lrDiagSum == -N || rlDiagSum == -N) {
            return "B";
        }
        if (moves.length < N * N) {
            return "Pending";
        }
        return "Draw";
    }

    public static void main(String[] args) {
        var sol = new Solution1275();
        var moves1 = new int[][] { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
        var moves2 = new int[][] { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
        System.out.println(sol.tictactoe(moves1)); // A
        System.out.println(sol.tictactoe(moves2)); // B
    }

}
