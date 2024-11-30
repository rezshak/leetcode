// https://leetcode.com/problems/meeting-rooms/

import java.util.*;

class Solution252 {

    // T: O(nlogn), S: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            var prev = intervals[i - 1];
            var curr = intervals[i];
            if (curr[0] < prev[1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution252();
        var intervals1 = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        var intervals2 = new int[][] { { 7, 10 }, { 2, 4 } };
        var intervals3 = new int[][] { { 0, 5 }, { 5, 10 } };
        var intervals4 = new int[][] {};
        System.out.println(sol.canAttendMeetings(intervals1)); // false
        System.out.println(sol.canAttendMeetings(intervals2)); // true
        System.out.println(sol.canAttendMeetings(intervals3)); // true
        System.out.println(sol.canAttendMeetings(intervals4)); // true
    }

}
