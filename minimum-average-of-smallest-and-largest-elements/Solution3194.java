// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/

import java.util.Arrays;

class Solution3194 {

    // T: O(nlogn), S: O(1)
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        double minAvg = Double.MAX_VALUE;
        while (left < right) {
            double currAvg = (nums[left] + nums[right]) / 2.0;
            minAvg = Math.min(minAvg, currAvg);
            left++;
            right--;
        }
        return minAvg;
    }

    public static void main(String[] args) {
        var sol = new Solution3194();
        var nums1 = new int[] { 7, 8, 3, 4, 15, 13, 4, 1 };
        var nums2 = new int[] { 1, 9, 8, 3, 10, 5 };
        var nums3 = new int[] { 1, 2, 3, 7, 8, 9 };
        System.out.println(sol.minimumAverage(nums1)); // 5.50000
        System.out.println(sol.minimumAverage(nums2)); // 5.50000
        System.out.println(sol.minimumAverage(nums3)); // 5.00000
    }

}
