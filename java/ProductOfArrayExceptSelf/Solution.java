// https://leetcode.com/problems/product-of-array-except-self/

package ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    // T: O(n), S: O(n)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);

        int left = 0, right = len - 1;
        int leftProduct = 1, rightProduct = 1;

        while (left < len && right >= 0) {
            result[left] *= leftProduct;
            result[right] *= rightProduct;
            leftProduct *= nums[left];
            rightProduct *= nums[right];
            left++;
            right--;
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 1, 2, 3, 4 }; // 24, 12, 8, 6
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1)));
        int[] nums2 = { -1, 1, 0, -3, 3 }; // 0,0 , 9, 0, 0
        System.out.println(Arrays.toString(sol.productExceptSelf(nums2)));
    }

}
