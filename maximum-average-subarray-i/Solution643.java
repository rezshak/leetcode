// https://leetcode.com/problems/maximum-average-subarray-i/

class Solution643 {

    // T: O(n), O(1)
    public double findMaxAverage(int[] nums, int k) {
        int runningSum = 0;
        double runningAvg = 0.0, maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            runningSum += nums[i];
        }
        runningAvg = runningSum / (double) k;
        maxAvg = Math.max(maxAvg, runningAvg);
        for (int i = k; i < nums.length; i++) {
            runningSum -= nums[i - k];
            runningSum += nums[i];
            runningAvg = runningSum / (double) k;
            maxAvg = Math.max(maxAvg, runningAvg);
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        var sol = new Solution643();
        var nums1 = new int[] { 1, 12, -5, -6, 50, 3 };
        var nums2 = new int[] { 5 };
        var nums3 = new int[] { -1 };
        System.out.println(sol.findMaxAverage(nums1, 4)); // 12.75000
        System.out.println(sol.findMaxAverage(nums2, 1)); // 5.00000
        System.out.println(sol.findMaxAverage(nums3, 1)); // -1.00000
    }

}
