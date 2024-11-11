// https://leetcode.com/problems/next-permutation/

import java.util.Arrays;

class Solution31 {

    // T: O(n), S: O(1)
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution31();
        var nums1 = new int[] { 1, 2, 3 };
        var nums2 = new int[] { 3, 2, 1 };
        var nums3 = new int[] { 1, 1, 5 };
        sol.nextPermutation(nums1);
        sol.nextPermutation(nums2);
        sol.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }

}
