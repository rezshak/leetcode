// https://leetcode.com/problems/sort-an-array/

import java.util.Arrays;

class Solution912 {

    // Merge sort
    // T: O(n log n), S: O(n)
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        var len = nums.length;
        var mid = len / 2;
        var nums1 = new int[mid];
        var nums2 = new int[len - mid];
        System.arraycopy(nums, 0, nums1, 0, mid);
        System.arraycopy(nums, mid, nums2, 0, len - mid);
        sortArray(nums1);
        sortArray(nums2);
        merge(nums, nums1, nums2);

        return nums;
    }

    private void merge(int[] nums, int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            nums[idx++] = nums1[idx1] <= nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
        }
        while (idx1 < len1) {
            nums[idx++] = nums1[idx1++];
        }
        while (idx2 < len2) {
            nums[idx++] = nums2[idx2++];
        }
    }

    public static void main(String[] args) {
        var sol = new Solution912();
        var nums1 = new int[] { 5, 2, 3, 1 };
        sol.sortArray(nums1);
        System.out.println(Arrays.toString(nums1));
        var nums2 = new int[] { 5, 1, 1, 2, 0, 0 };
        sol.sortArray(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}
