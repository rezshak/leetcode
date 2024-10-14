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
        for (int i = 1; i < numRows; i++) {
            var newRow = new ArrayList<Integer>();
            var prevRow = triangle.get(i - 1);
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
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
