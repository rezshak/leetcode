// https://leetcode.com/problems/predict-the-winner/

import java.util.HashMap;
import java.util.Map;

class Solution486 {

    // T: (O(n^2)), S: (O(n^2))
    public boolean predictTheWinner(int[] nums) {
        var memo = new HashMap<String, Integer>();
        return turn(nums, 0, nums.length - 1, true, memo) >= 0;
    }

    private int turn(int[] nums, int l, int r, boolean player1, Map<String, Integer> memo) {
        String key = l + "," + r + "," + player1;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (l > r) {
            return 0;
        }
        int result = 0;
        if (player1) {
            result = Math.max(
                    nums[l] + turn(nums, l + 1, r, false, memo),
                    nums[r] + turn(nums, l, r - 1, false, memo));
        } else {
            result = Math.min(
                    -nums[l] + turn(nums, l + 1, r, true, memo),
                    -nums[r] + turn(nums, l, r - 1, true, memo));
        }
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution486();
        var nums1 = new int[] { 1, 5, 2 };
        var nums2 = new int[] { 1, 5, 233, 7 };
        System.out.println(sol.predictTheWinner(nums1)); // false
        System.out.println(sol.predictTheWinner(nums2)); // true
    }

}
