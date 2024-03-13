// https://leetcode.com/problems/product-of-array-except-self/

package ProductOfArrayExceptSelf;

import java.util.Arrays;

class Solution {

    // T: O(n), S: O(n)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < len; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }

    // T: O(n), S: O(1)
    public int[] productExceptSelfOpt(int[] nums) {
        int len = nums.length;
        var output = new int[len];
        output[0] = 1;
        for (int i = 1; i < len; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 1, 2, 3, 4 }; // 24, 12, 8, 6
        int[] nums2 = { -1, 1, 0, -3, 3 }; // 0, 0, 9, 0, 0
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1)));
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums1)));
        System.out.println(Arrays.toString(sol.productExceptSelf(nums2)));
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums2)));
    }

}
