// https://leetcode.com/problems/missing-ranges/

import java.util.*;

class Solution163 {

    // T: O(n), S: O(1)
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        var result = new ArrayList<List<Integer>>();
        int n = nums.length;

        if (n == 0) {
            result.add(List.of(lower, upper));
            return result;
        }
        if (nums[0] > lower) {
            result.add(List.of(lower, nums[0] - 1));
        }

        // Handle ranges between elements
        for (int i = 0; i < n - 1; i++) {
            int curr = nums[i], next = nums[i + 1];
            if (next - curr > 1) {
                result.add(List.of(curr + 1, next - 1));
            }
        }

        if (nums[n - 1] < upper) {
            result.add(List.of(nums[n - 1] + 1, upper));
        }

        return result;
    }

    // T: O(n), S: O(1)
    public List<List<Integer>> findMissingRangesOpt(int[] nums, int lower, int upper) {
        var result = new ArrayList<List<Integer>>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (curr - prev > 1) {
                result.add(List.of(prev + 1, curr - 1));
            }
            prev = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution163();
        var nums1 = new int[] { 0, 1, 3, 50, 75 };
        var nums2 = new int[] { -1 };
        System.out.println(sol.findMissingRanges(nums1, 0, 99)); // [[2,2],[4,49],[51,74],[76,99]]
        System.out.println(sol.findMissingRangesOpt(nums1, 0, 99)); // [[2,2],[4,49],[51,74],[76,99]]
        System.out.println(sol.findMissingRanges(nums2, -1, -1)); // []
        System.out.println(sol.findMissingRangesOpt(nums2, -1, -1)); // []
    }

}
