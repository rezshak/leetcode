// https://leetcode.com/problems/insert-interval/

import java.util.*;

class Solution57 {

    // T: O(n), S: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new ArrayList<int[]>();
        int n = intervals.length, i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        var sol = new Solution57();
        var intervals1 = new int[][] { { 1, 3 }, { 6, 9 } };
        var newInterval1 = new int[] { 2, 5 };
        var intervals2 = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        var newInterval2 = new int[] { 4, 8 };
        System.out.println(Arrays.deepToString(sol.insert(intervals1, newInterval1)));
        System.out.println(Arrays.deepToString(sol.insert(intervals2, newInterval2)));
    }

}
