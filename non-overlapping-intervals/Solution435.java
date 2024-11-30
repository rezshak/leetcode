// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

class Solution435 {

    // T: O(nlogn), S: O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // Sort by end times
        int n = intervals.length;
        int nonOverlappingCount = 1; // First interval is always counted
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            // If current interval starts after previous interval ends,
            // we can include it without overlap
            if (currStart >= prevEnd) {
                nonOverlappingCount++;
                prevEnd = intervals[i][1];
            }
        }

        return n - nonOverlappingCount;
    }

    public static void main(String[] args) {
        var sol = new Solution435();
        var intervals1 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        var intervals2 = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        var intervals3 = new int[][] { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
        System.out.println(sol.eraseOverlapIntervals(intervals2)); // 2
        System.out.println(sol.eraseOverlapIntervals(intervals1)); // 1
        System.out.println(sol.eraseOverlapIntervals(intervals3)); // 2
    }

}
