// https://leetcode.com/problems/interval-list-intersections/

import java.util.ArrayList;
import java.util.Arrays;

class Solution986 {

    // T: O(n+m), S: O(min(n, m))
    public int[][] intervalIntersection(int[][] list1, int[][] list2) {
        var result = new ArrayList<int[]>();
        int p1 = 0, p2 = 0;
        while (p1 < list1.length && p2 < list2.length) {
            int start1 = list1[p1][0], end1 = list1[p1][1];
            int start2 = list2[p2][0], end2 = list2[p2][1];
            if (end1 < start2) {
                p1++;
            } else if (end2 < start1) {
                p2++;
            } else {
                int start = Math.max(start1, start2);
                int end = Math.min(end1, end2);
                result.add(new int[] { start, end });
                if (end1 < end2) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        var sol = new Solution986();
        var list1 = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        var list2 = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(sol.intervalIntersection(list1, list2)));
        list1 = new int[][] { { 1, 3 }, { 5, 9 } };
        list2 = new int[][] {};
        // []
        System.out.println(Arrays.deepToString(sol.intervalIntersection(list1, list2)));
    }

}
