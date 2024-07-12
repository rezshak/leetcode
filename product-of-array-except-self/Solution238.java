// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

class Solution238 {

    // T: O(n), S: O(n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        var ans = new int[n];
        var left = new int[n];
        var right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // T: O(n), S: O(1)
    public int[] productExceptSelfOpt(int[] nums) {
        int n = nums.length;
        var ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution238();
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums1))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelf(nums2))); // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums2))); // [0, 0, 9, 0, 0]
    }

}
