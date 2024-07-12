// https://leetcode.com/problems/height-checker/

import java.util.Arrays;

class Solution1051 {

    // T: O(n log n), S: O(n)
    public int heightChecker(int[] heights) {
        var expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution1051();
        var nums1 = new int[] { 1, 1, 4, 2, 1, 3 };
        var nums2 = new int[] { 5, 1, 2, 3, 4 };
        var nums3 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(sol.heightChecker(nums1)); // 3
        System.out.println(sol.heightChecker(nums2)); // 5
        System.out.println(sol.heightChecker(nums3)); // 0
    }

}
