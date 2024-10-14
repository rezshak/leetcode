// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

import java.util.Arrays;

class Solution1464 {

    // T: O(n), S: O(1)
    public int maxProduct(int[] nums) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > a) {
                b = a;
                a = n;
            } else if (n > b) {
                b = n;
            }
        }
        return (a - 1) * (b - 1);
    }

    // T: O(nlogn), S: O(1)
    public int maxProductSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, max1 = nums[n - 1], max2 = nums[n - 2];
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        var sol = new Solution1464();
        var nums1 = new int[] { 3, 4, 5, 2 };
        var nums2 = new int[] { 1, 5, 4, 5 };
        var nums3 = new int[] { 3, 7 };
        System.out.println(sol.maxProduct(nums1)); // 12
        System.out.println(sol.maxProductSort(nums1)); // 12
        System.out.println(sol.maxProduct(nums2)); // 16
        System.out.println(sol.maxProductSort(nums2)); // 16
        System.out.println(sol.maxProduct(nums3)); // 12
        System.out.println(sol.maxProductSort(nums3)); // 12
    }

}
