// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

class Solution46 {

    // T: O(n*n!), S: O(n*n!)
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        backtrack(nums, result, curr);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(nums, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    // T: O(n*n!), S: O(n*n!)
    public List<List<Integer>> permuteIterative(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            var curr = new ArrayList<List<Integer>>();
            for (var perm : result) {
                for (int i = 0; i <= perm.size(); i++) {
                    var newPerm = new ArrayList<Integer>(perm);
                    newPerm.add(i, num);
                    curr.add(newPerm);
                }
            }
            result = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution46();
        var nums1 = new int[] { 1, 2, 3 };
        var nums2 = new int[] { 0, 1 };
        var nums3 = new int[] { 1 };
        System.out.println(sol.permute(nums1)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(sol.permute(nums2)); // [[0,1],[1,0]]
        System.out.println(sol.permute(nums3)); // [[1]]
        System.out.println(sol.permuteIterative(nums1)); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(sol.permuteIterative(nums2)); // [[0,1],[1,0]]
        System.out.println(sol.permuteIterative(nums3)); // [[1]]
    }

}
