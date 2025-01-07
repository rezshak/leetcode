// https://leetcode.com/problems/concatenation-of-array/

import java.util.Arrays;

class Solution1929 {

    // T: O(n), S: O(n)
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        var ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    // T: O(n), S: O(n)
    public int[] getConcatenationBuiltin(int[] nums) {
        int n = nums.length;
        var ans = new int[n * 2];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution1929();
        int[][] testCases = {
                { 1, 2, 1 },
                { 1, 3, 2, 1 },
                { 1, 2, 3, 4 }
        };
        for (int[] nums : testCases) {
            var ans = sol.getConcatenation(nums);
            System.out.println(Arrays.toString(ans));
        }
        System.out.println(Arrays.toString(sol.getConcatenationBuiltin(new int[] { 1, 2, 3 })));
    }

}
