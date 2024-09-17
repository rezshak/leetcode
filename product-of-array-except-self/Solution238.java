// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

class Solution238 {

    // T: O(n), S: O(n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        var prefix = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = left;
            left *= nums[i];
        }
        var postfix = new int[n];
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            postfix[i] = right;
            right *= nums[i];
        }
        var output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = prefix[i] * postfix[i];
        }
        return output;
    }

    // T: O(n), S: O(1)
    public int[] productExceptSelfOpt(int[] nums) {
        int n = nums.length;
        var output = new int[n];
        int right = 1, left = 1;
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        var sol = new Solution238();
        var nums1 = new int[] { 1, 2, 3, 4 };
        var nums2 = new int[] { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums1))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(sol.productExceptSelf(nums2))); // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(sol.productExceptSelfOpt(nums2))); // [0, 0, 9, 0, 0]
    }

}
