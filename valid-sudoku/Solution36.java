// https://leetcode.com/problems/valid-sudoku/

import java.util.*;

class Solution36 {

    // T: O(1), S: O(1)
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        // Validate rows
        for (int r = 0; r < 9; r++) {
            var counts = getDigitsMap();
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                if (!counts.containsKey(ch) || counts.get(ch) >= 1) {
                    return false;
                }
                counts.put(ch, counts.get(ch) + 1);
            }
        }
        // Validate cols
        for (int c = 0; c < 9; c++) {
            var counts = getDigitsMap();
            for (int r = 0; r < 9; r++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                if (!counts.containsKey(ch) || counts.get(ch) >= 1) {
                    return false;
                }
                counts.put(ch, counts.get(ch) + 1);
            }
        }
        // Validate grids
        for (int r = 0; r < 9; r++) {
            var counts = getDigitsMap();
            for (int c = 0; c < 9; c++) {
                int row = 3 * (r / 3) + c / 3;
                int col = 3 * (r % 3) + c % 3;
                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }
                if (!counts.containsKey(ch) || counts.get(ch) >= 1) {
                    return false;
                }
                counts.put(ch, counts.get(ch) + 1);
            }
        }

        return true;
    }

    private Map<Character, Integer> getDigitsMap() {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch = '1'; ch <= '9'; ch++) {
            map.put(ch, 0);
        }
        return map;
    }

}
