// https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

class Solution88 {

    // T: O(n+m), S: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = nums1.length - 1;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[idx1--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while (p2 >= 0) {
            nums1[idx1--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        var sol = new Solution88();
        var nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        var nums2 = new int[] { 2, 5, 6 };
        sol.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
        nums1 = new int[] { 1 };
        nums2 = new int[] {};
        sol.merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1)); // [1]
    }

}
