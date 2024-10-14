// https://leetcode.com/problems/missing-number/

import java.util.*;

class Solution268 {

    // T: O(n), S: O(1)
    public int missingNumberSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // T: O(n), S: O(1)
    public int missingNumberXor(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // T: O(n), S: O(n)
    public int missingNumberBitSet(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        var set = new BitSet(n + 1);
        for (int num : nums) {
            set.set(num);
        }
        for (int i = 0; i < n + 1; i++) {
            if (set.get(i) == false) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution268();
        var nums1 = new int[] { 3, 0, 1 };
        var nums2 = new int[] { 0, 1 };
        var nums3 = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

        System.out.println(sol.missingNumberSum(nums1)); // 2
        System.out.println(sol.missingNumberXor(nums1)); // 2
        System.out.println(sol.missingNumberBitSet(nums1)); // 2

        System.out.println(sol.missingNumberSum(nums2)); // 2
        System.out.println(sol.missingNumberXor(nums2)); // 2
        System.out.println(sol.missingNumberBitSet(nums2)); // 2

        System.out.println(sol.missingNumberSum(nums3)); // 8
        System.out.println(sol.missingNumberXor(nums3)); // 8
        System.out.println(sol.missingNumberBitSet(nums3)); // 8
    }

}
