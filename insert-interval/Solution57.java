// https://leetcode.com/problems/insert-interval/

import java.util.*;

class Solution57 {

    // T: O(n), S: O(n)
    public static int[][] insert(int[][] existingIntervals, int[] newInterval) {
        var result = new ArrayList<int[]>();
        int i = 0;
        while (i < existingIntervals.length && existingIntervals[i][1] < newInterval[0]) {
            result.add(existingIntervals[i]);
            i++;
        }
        while (i < existingIntervals.length && existingIntervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], existingIntervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], existingIntervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < existingIntervals.length) {
            result.add(existingIntervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][][] existingIntervals = {
                { { 1, 3 }, { 6, 9 } },
                { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }
        };
        int[][] newIntervals = {
                { 2, 5 },
                { 4, 8 }
        };
        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print("\nExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("New interval: " + Arrays.toString(newIntervals[i]));
            int[][] output = insert(existingIntervals[i], newIntervals[i]);
            System.out.println("Updated intervals: " + Arrays.deepToString(output));
        }
    }

}
