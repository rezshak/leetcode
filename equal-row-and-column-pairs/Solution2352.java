// https://leetcode.com/problems/equal-row-and-column-pairs/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution2352 {

    // T: O(n^2), S: O(n^2)
    public int equalPairs(int[][] grid) {
        int n = grid.length, pairsCount = 0;
        var rowsMap = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            var key = getKeyAsList(row);
            rowsMap.put(key, rowsMap.getOrDefault(key, 0) + 1);
        }
        for (int col = 0; col < n; col++) {
            int[] colArr = new int[n];
            for (int row = 0; row < n; row++) {
                colArr[row] = grid[row][col];
            }
            var key = getKeyAsList(colArr);
            if (rowsMap.containsKey(key)) {
                pairsCount += rowsMap.get(key);
            }
        }
        return pairsCount;
    }

    private static List<Integer> getKeyAsList(int[] arr) {
        var list = new ArrayList<Integer>(arr.length);
        for (int n : arr) {
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        var sol = new Solution2352();
        var grid1 = new int[][] {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        var grid2 = new int[][] {
                { 3, 1, 2, 2 },
                { 1, 4, 4, 5 },
                { 2, 4, 2, 2 },
                { 2, 4, 2, 2 }
        };
        System.out.println(sol.equalPairs(grid1)); // 1
        System.out.println(sol.equalPairs(grid2)); // 3
    }

}
