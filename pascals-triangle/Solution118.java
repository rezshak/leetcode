// https://leetcode.com/problems/pascals-triangle/

import java.util.*;

class Solution118 {

    // T: O(n^2), S: O(n^2)
    public List<List<Integer>> generate(int numRows) {
        var triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(List.of(1));
        for (int r = 1; r < numRows; r++) {
            var newRow = new ArrayList<Integer>();
            var prevRow = triangle.get(r - 1);
            newRow.add(1);
            for (int c = 1; c < prevRow.size(); c++) {
                int num = prevRow.get(c - 1) + prevRow.get(c);
                newRow.add(num);
            }
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        var sol = new Solution118();
        System.out.println(sol.generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        System.out.println(sol.generate(1)); // [[1]]
    }

}
