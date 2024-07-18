// https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution209 {

    // T: O(n), S: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int minWinSize = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int currWinSize = right - left + 1;
                minWinSize = Math.min(minWinSize, currWinSize);
                sum -= nums[left];
                left++;
            }
        }
        return minWinSize != Integer.MAX_VALUE ? minWinSize : 0;
    }

    public static void main(String[] args) {
        var sol = new Solution209();
        var nums1 = new int[] { 2, 3, 1, 2, 4, 3 };
        var nums2 = new int[] { 1, 4, 4 };
        var nums3 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(sol.minSubArrayLen(7, nums1)); // 2
        System.out.println(sol.minSubArrayLen(4, nums2)); // 1
        System.out.println(sol.minSubArrayLen(11, nums3)); // 0
    }

}
