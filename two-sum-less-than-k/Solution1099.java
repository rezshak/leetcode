// https://leetcode.com/problems/two-sum-less-than-k/

import java.util.Arrays;

class Solution1099 {

    // T: O(nlogn) S: O(1)
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                ans = Math.max(ans, sum);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution1099();
        var nums1 = new int[] { 34, 23, 1, 24, 75, 33, 54, 8 };
        var nums2 = new int[] { 10, 20, 30 };
        System.out.println(sol.twoSumLessThanK(nums1, 60)); // 58
        System.out.println(sol.twoSumLessThanK(nums2, 15)); // -1
    }

}
