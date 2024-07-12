// https://leetcode.com/problems/sort-array-by-parity-ii/

import java.util.Arrays;

class Solution922 {

    // T: O(n), S: O(n)
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        var ans = new int[n];
        int j = 0, k = 1;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 0) {
                ans[j] = nums[i];
                j += 2;
            } else {
                ans[k] = nums[i];
                k += 2;
            }
        }
        return ans;
    }

    // T: O(n), S: O(1)
    public int[] sortArrayByParityIIOpt(int[] nums) {
        int n = nums.length;
        int evenPtr = 0, oddPtr = 1;
        while (evenPtr < n && oddPtr < n) {
            if ((nums[evenPtr] & 1) == 0) {
                evenPtr += 2;
            } else if ((nums[oddPtr] & 1) == 1) {
                oddPtr += 2;
            } else {
                int temp = nums[evenPtr];
                nums[evenPtr] = nums[oddPtr];
                nums[oddPtr] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        var sol = new Solution922();
        var nums1 = new int[] { 4, 2, 5, 7 };
        var nums2 = new int[] { 2, 3 };
        System.out.println(Arrays.toString(sol.sortArrayByParityII(nums1))); // [4,5,2,7]
        System.out.println(Arrays.toString(sol.sortArrayByParityIIOpt(nums1))); // [4,5,2,7]
        System.out.println(Arrays.toString(sol.sortArrayByParityII(nums2))); // [2,3]
        System.out.println(Arrays.toString(sol.sortArrayByParityIIOpt(nums2))); // [2,3]
    }

}
