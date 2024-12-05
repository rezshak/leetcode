// https://leetcode.com/problems/number-of-islands/

class Solution200 {

    // T: O(n*m), S: O(1)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If we find a land cell ('1'), increment island count and explore the island
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        // Check for out of bounds or water cell
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }

        // Mark current cell as visited by changing '1' to '0'
        grid[r][c] = '0';

        // Explore 4-directionally adjacent cells
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }

    public static void main(String[] args) {
        var sol = new Solution200();
        var grid1 = new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(sol.numIslands(grid1)); // 1
        var grid2 = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(sol.numIslands(grid2)); // 3
    }

}
