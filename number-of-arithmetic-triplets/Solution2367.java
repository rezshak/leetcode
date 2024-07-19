// https://leetcode.com/problems/number-of-arithmetic-triplets/

import java.util.*;

class Solution2367 {

    // T: O(n), S: O(n)
    public int arithmeticTriplets(int[] nums, int diff) {
        var numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (numSet.contains(num + diff) && numSet.contains(num + diff + diff)) {
                count++;
            }
        }
        return count;
    }

    // T: O(n^3), S: O(n^3)
    public int arithmeticTripletsBrute(int[] nums, int diff) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int n1 = nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                int n2 = nums[j];
                if (n2 == n1 + diff) {
                    for (int k = j + 1; k < n; k++) {
                        int n3 = nums[k];
                        if (n3 == n2 + diff) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution2367();
        var nums1 = new int[] { 0, 1, 4, 6, 7, 10 };
        var nums2 = new int[] { 4, 5, 6, 7, 8, 9 };
        System.out.println(sol.arithmeticTriplets(nums1, 3)); // 2
        System.out.println(sol.arithmeticTripletsBrute(nums1, 3)); // 2
        System.out.println(sol.arithmeticTriplets(nums2, 2)); // 2
        System.out.println(sol.arithmeticTripletsBrute(nums2, 2)); // 2
    }

}
