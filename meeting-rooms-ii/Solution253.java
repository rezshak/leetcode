// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.*;

class Solution253 {

    // T: O(nlogn), S: O(n)
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        var start = new int[n];
        var end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int result = 0, count = 0;
        int s = 0, e = 0;
        while (s < n) {
            if (start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    // T: O(nlogn), S: O(n)
    public int minMeetingRoomsPq(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        var endTimes = new PriorityQueue<Integer>();
        endTimes.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            if (startTime >= endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.offer(intervals[i][1]);
        }

        return endTimes.size();
    }

    public static void main(String[] args) {
        var sol = new Solution253();
        var intervals1 = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        var intervals2 = new int[][] { { 7, 10 }, { 2, 4 } };
        System.out.println(sol.minMeetingRooms(intervals1)); // 2
        System.out.println(sol.minMeetingRoomsPq(intervals1)); // 2
        System.out.println(sol.minMeetingRooms(intervals2)); // 1
        System.out.println(sol.minMeetingRoomsPq(intervals2)); // 1
    }

}
