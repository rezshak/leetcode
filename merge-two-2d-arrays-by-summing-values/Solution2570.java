// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

import java.util.*;

class Solution2570 {

    // T: O: (nlogn), S: O(n)
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        var map = new TreeMap<Integer, Integer>();
        for (var row : nums1) {
            map.put(row[0], row[1]);
        }
        for (var row : nums2) {
            map.put(row[0], map.getOrDefault(row[0], 0) + row[1]);
        }
        var result = new int[map.size()][2];
        int i = 0;
        for (var entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }

    // T: O(n+m), S: O(n+m)
    public int[][] mergeArraysTwoPtr(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] ans = new int[len1 + len2][2];
        int r1 = 0, r2 = 0, i = 0;
        while (r1 < len1 && r2 < len2) {
            if (nums1[r1][0] == nums2[r2][0]) {
                ans[i][0] = nums1[r1][0];
                ans[i][1] = nums1[r1][1] + nums2[r2][1];
                r1++;
                r2++;
            } else if (nums1[r1][0] < nums2[r2][0]) {
                ans[i][0] = nums1[r1][0];
                ans[i][1] = nums1[r1][1];
                r1++;
            } else {
                ans[i][0] = nums2[r2][0];
                ans[i][1] = nums2[r2][1];
                r2++;
            }
            i++;
        }
        while (r1 < len1) {
            ans[i][0] = nums1[r1][0];
            ans[i][1] = nums1[r1][1];
            r1++;
            i++;
        }
        while (r2 < len2) {
            ans[i][0] = nums2[r2][0];
            ans[i][1] = nums2[r2][1];
            r2++;
            i++;
        }
        return Arrays.copyOf(ans, i);
    }

    private static void print2DArray(int[][] nums) {
        var sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(Arrays.toString(nums[i]));
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        var sol = new Solution2570();
        var nums1 = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        var nums2 = new int[][] { { 1, 6 }, { 2, 3 }, { 3, 2 }, { 4, 6 } };
        print2DArray(sol.mergeArrays(nums1, nums2));
        print2DArray(sol.mergeArraysTwoPtr(nums1, nums2));
        nums1 = new int[][] { { 2, 4 }, { 3, 6 }, { 5, 5 } };
        nums2 = new int[][] { { 1, 3 }, { 4, 3 } };
        print2DArray(sol.mergeArrays(nums1, nums2));
        print2DArray(sol.mergeArraysTwoPtr(nums1, nums2));
    }

}
