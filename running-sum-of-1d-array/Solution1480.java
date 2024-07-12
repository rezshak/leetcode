// https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;

class Solution1480 {

    // T: O(n), S: O(n)
    public int[] runningSum(int[] nums) {
        var result = new int[nums.length];
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            result[i] = runningSum;
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution1480();
        var nums1 = new int[] { 1, 2, 3, 4 };
        var nums2 = new int[] { 1, 1, 1, 1, 1 };
        var nums3 = new int[] { 3, 1, 2, 10, 1 };
        System.out.println(Arrays.toString(sol.runningSum(nums1))); // [1,3,6,10]
        System.out.println(Arrays.toString(sol.runningSum(nums2))); // [1,2,3,4,5]
        System.out.println(Arrays.toString(sol.runningSum(nums3))); // [3,4,6,16,17]
    }

}
