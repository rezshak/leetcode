// https://leetcode.com/problems/subsets/

import java.util.*;

class Solution78 {

    // T: O(n2^n), S: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        backtrack(nums, 0, curr, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    // T: O(n2^n), S: O(n2^n)
    public List<List<Integer>> subsetsBitmask(int[] nums) {
        int n = nums.length;
        int total = 1 << n; // 2^n
        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < total; i++) {
            var curr = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // If the j-th bit in i is set, include nums[j] in the current subset.
                int mask = 1 << j;
                if ((i & mask) != 0) {
                    curr.add(nums[j]);
                }
            }
            result.add(curr);
        }
        return result;
    }

    // T: O(2^n), S: O(n2^n)
    public List<List<Integer>> subsetsIterative(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                var newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        return result;
    }

    // T: O(2^n), S: O(n2^n)
    public List<List<Integer>> subsetsBrute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        generateSubsets(nums, 0, curr, result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        generateSubsets(nums, index + 1, curr, result);
        curr.add(nums[index]);
        generateSubsets(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        var sol = new Solution78();
        var nums1 = new int[] { 1, 2, 3 };
        var nums2 = new int[] { 0 };
        System.out.println(sol.subsets(nums1)); // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
        System.out.println(sol.subsetsBitmask(nums1));
        System.out.println(sol.subsetsIterative(nums1));
        System.out.println(sol.subsetsBrute(nums1));
        System.out.println(sol.subsets(nums2)); // [[],[0]]
    }

}
