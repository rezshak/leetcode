// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/

import java.util.Arrays;

class Solution2903 {

    // T: O(n^2), S: O(1)
    public int[] findIndices(int[] nums, int idxDiff, int valDiff) {
        int n = nums.length;
        for (int i = 0; i < n - idxDiff; i++) {
            for (int j = i + idxDiff; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valDiff) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // T: O(n), S: O()
    public int[] findIndicesOpt(int[] nums, int idxDiff, int valDiff) {
        int n = nums.length, min = 0, max = 0;
        for (int i = idxDiff; i < n; i++) {
            if (nums[i - idxDiff] < nums[min]) {
                min = i - idxDiff;
            }
            if (nums[i - idxDiff] > nums[max]) {
                max = i - idxDiff;
            }
            if (nums[i] - nums[min] >= valDiff) {
                return new int[] { min, i };
            }
            if (nums[max] - nums[i] >= valDiff) {
                return new int[] { max, i };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        var sol = new Solution2903();
        var nums1 = new int[] { 5, 1, 4, 1 };
        var nums2 = new int[] { 2, 1 };
        var nums3 = new int[] { 1, 2, 3 };
        var nums4 = new int[] { 0 };
        System.out.println(Arrays.toString(sol.findIndices(nums1, 2, 4))); // [0,3]
        System.out.println(Arrays.toString(sol.findIndicesOpt(nums1, 2, 4))); // [0,3]
        System.out.println(Arrays.toString(sol.findIndices(nums2, 0, 0))); // [0,1]
        System.out.println(Arrays.toString(sol.findIndicesOpt(nums2, 0, 0))); // [0,1]
        System.out.println(Arrays.toString(sol.findIndices(nums3, 2, 4))); // [-1,-1]
        System.out.println(Arrays.toString(sol.findIndicesOpt(nums3, 2, 4))); // [-1,-1]
        System.out.println(Arrays.toString(sol.findIndices(nums4, 0, 0))); // [0,0]
        System.out.println(Arrays.toString(sol.findIndicesOpt(nums4, 0, 0))); // [0,0]
    }

}
