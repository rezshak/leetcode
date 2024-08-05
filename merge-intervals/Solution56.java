// https://leetcode.com/problems/merge-intervals/

import java.util.*;

class Solution56 {

    // T: O(nlogn), S: O(n)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        var merged = new ArrayList<int[]>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            var prevInterval = merged.getLast();
            var currInterval = intervals[i];
            if (currInterval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                merged.add(currInterval);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    public static void main(String[] args) {
        var sol = new Solution56();
        var intervals1 = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        var intervals2 = new int[][] { { 1, 4 }, { 4, 5 } };
        System.out.println(Arrays.deepToString(sol.merge(intervals1))); // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(sol.merge(intervals2))); // [[1,5]]
    }

}
