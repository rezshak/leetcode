// https://leetcode.com/problems/apply-operations-to-an-array/

import java.util.Arrays;

class Solution2460 {

    // T: O(n), S: O(1)
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < n) {
            nums[j] = 0;
            j++;
        }
        return nums;
    }

    public static void main(String[] args) {
        var sol = new Solution2460();
        var nums1 = new int[] { 1, 2, 2, 1, 1, 0 };
        var nums2 = new int[] { 0, 1 };
        System.out.println(Arrays.toString(sol.applyOperations(nums1))); // [1,4,2,0,0,0]
        System.out.println(Arrays.toString(sol.applyOperations(nums2))); // [1,0]
    }

}
