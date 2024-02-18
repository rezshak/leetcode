// https://leetcode.com/problems/sort-colors/

package SortColors;

import java.util.Arrays;

public class Solution {

    // T: O(n), S: O(1)
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        int[] nums2 = { 2, 0, 1 };
        sol.sortColors(nums1);
        sol.sortColors(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

}
