// https://leetcode.com/problems/word-search/

class Solution79 {

    // T: O(m * n * 4^L), S: O(L)
    public boolean exist(char[][] board, String word) {
        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Start the backtracking search from the current cell
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // T: O(4^L), S: O(L)
    private boolean backtrack(char[][] board, String word, int i, int j, int idx) {
        // If the entire word is found, return true
        if (idx == word.length()) {
            return true;
        }

        // Check boundaries and if current cell matches the current character in word
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark the current cell as visited by temporarily changing its value
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four possible directions (up, down, left, right)
        boolean found = backtrack(board, word, i + 1, j, idx + 1) ||
                backtrack(board, word, i - 1, j, idx + 1) ||
                backtrack(board, word, i, j + 1, idx + 1) ||
                backtrack(board, word, i, j - 1, idx + 1);

        // Restore the original value of the cell
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        var sol = new Solution79();

        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        System.out.println(sol.exist(board1, word1)); // true

        char[][] board2 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word2 = "SEE";
        System.out.println(sol.exist(board2, word2)); // true

        char[][] board3 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word3 = "ABCB";
        System.out.println(sol.exist(board3, word3)); // false
    }

}
