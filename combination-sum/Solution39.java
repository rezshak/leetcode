// https://leetcode.com/problems/combination-sum/

import java.util.*;

class Solution39 {

    // T: O(2^t), S: O(t)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        // Sort the array to facilitate the pruning of branches
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    // T: O(2^t), S: O(t)
    private void backtrack(int[] candidates, int target, int total, int start, List<Integer> curr,
            List<List<Integer>> result) {
        // If the current total equals the target, add the combination to the result
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // If adding the current number exceeds the target, break the loop
            if (total + candidates[i] > target) {
                break;
            }
            // Add the current number to the combination
            curr.add(candidates[i]);
            // Recur with updated total and current list
            backtrack(candidates, target, total + candidates[i], i, curr, result);
            // Remove the last added number to backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        var sol = new Solution39();

        var candidates1 = new int[] { 2, 3, 6, 7 };
        int target1 = 7;
        var result1 = sol.combinationSum(candidates1, target1);
        System.out.println(result1); // [[2, 2, 3], [7]]

        var candidates2 = new int[] { 2, 3, 5 };
        int target2 = 8;
        var result2 = sol.combinationSum(candidates2, target2);
        System.out.println(result2); // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        var candidates3 = new int[] { 2 };
        int target3 = 3;
        var result3 = sol.combinationSum(candidates3, target3);
        System.out.println(result3); // []
    }

}
