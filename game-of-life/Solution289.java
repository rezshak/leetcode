// https://leetcode.com/problems/game-of-life/

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution289 {

    // T: O(mn), S: O(mn)
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        var newBoard = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                newBoard[row][col] = board[row][col];
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                int top = max(0, row - 1);
                int bottom = min(rows - 1, row + 1);
                int left = max(0, col - 1);
                int right = min(cols - 1, col + 1);
                for (int r = top; r <= bottom; r++) {
                    for (int c = left; c <= right; c++) {
                        if (!(r == row && c == col) && newBoard[r][c] == 1) {
                            liveNeighbors++;
                        }
                    }
                }
                if (liveNeighbors < 2 || liveNeighbors > 3) {
                    board[row][col] = 0;
                } else if (liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    // T: O(mn), S: O(1)
    public void gameOfLifeOpt(int[][] board) {
        int rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                int top = Math.max(0, row - 1);
                int bottom = Math.min(rows - 1, row + 1);
                int left = Math.max(0, col - 1);
                int right = Math.min(cols - 1, col + 1);
                for (int r = top; r <= bottom; r++) {
                    for (int c = left; c <= right; c++) {
                        // Skip the current cell itself, count the live neighbors
                        if (!(r == row && c == col) && Math.abs(board[r][c]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }
                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1; // Mark as "was alive, now dead"
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[row][col] = 2; // Mark as "was dead, now alive"
                    }
                }
            }
        }
        // Second pass: convert the transitional states to final states
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = board[row][col] > 0 ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        var sol = new Solution289();

        var board1 = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        sol.gameOfLife(board1);
        System.out.println(Arrays.deepToString(board1));

        var board2 = new int[][] {
                { 1, 1 },
                { 1, 0 }
        };
        sol.gameOfLife(board2);
        System.out.println(Arrays.deepToString(board2));

        var board3 = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        sol.gameOfLife(board3);
        System.out.println(Arrays.deepToString(board3));

        var board4 = new int[][] {
                { 1, 1 },
                { 1, 0 }
        };
        sol.gameOfLife(board4);
        System.out.println(Arrays.deepToString(board4));
    }

}
