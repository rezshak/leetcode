// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.Arrays;

class Solution167 {

    // T: O(n), S: O(1)
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == target) {
                return new int[] { left + 1, right + 1 };
            }
            if (currSum < target) {
                left++;
            } else if (currSum > target) {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        var sol = new Solution167();
        var nums1 = new int[] { 2, 7, 11, 15 };
        var nums2 = new int[] { 2, 3, 4 };
        var nums3 = new int[] { -1, 0 };
        System.out.println(Arrays.toString(sol.twoSum(nums1, 9))); // [1,2]
        System.out.println(Arrays.toString(sol.twoSum(nums2, 6))); // [1,3]
        System.out.println(Arrays.toString(sol.twoSum(nums3, -1))); // [1,2]
    }

}
