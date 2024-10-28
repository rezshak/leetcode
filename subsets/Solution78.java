// https://leetcode.com/problems/subsets/

import java.util.*;

class Solution78 {

    // T: O(n2^n), S: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        backtrack(0, nums, result, curr);
        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> curr) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, nums, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    // T: O(2^n), S: O(n2^n)
    public List<List<Integer>> subsetsBitmask(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n total subsets
        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < totalSubsets; i++) {
            var curr = new ArrayList<Integer>();

            for (int j = 0; j < n; j++) {
                // If the j-th bit in i is set, include nums[j] in the current subset.
                if ((i & (1 << j)) != 0) {
                    curr.add(nums[j]);
                }
            }

            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution78();
        var nums1 = new int[] { 1, 2, 3 };
        var nums2 = new int[] { 0 };
        System.out.println(sol.subsets(nums1)); // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
        System.out.println(sol.subsets(nums2)); // [[],[0]]
    }

}
