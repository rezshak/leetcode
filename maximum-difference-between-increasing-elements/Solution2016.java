// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

class Solution2016 {

    // T: O(n), S: O(n)
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        var rightMaxes = new int[n];
        rightMaxes[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxes[i] = Math.max(rightMaxes[i + 1], nums[i]);
        }
        int maxDiff = -1;
        for (int i = 0; i < n; i++) {
            if (rightMaxes[i] > nums[i]) {
                maxDiff = Math.max(maxDiff, rightMaxes[i] - nums[i]);
            }
        }
        return maxDiff;
    }

    // T: O(n), S: O(1)
    public int maximumDifferenceOpt(int[] nums) {
        int n = nums.length;
        int rightMax = nums[n - 1], maxDiff = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < rightMax) {
                maxDiff = Math.max(maxDiff, rightMax - nums[i]);
            }
            rightMax = Math.max(rightMax, nums[i]);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        var sol = new Solution2016();
        var nums1 = new int[] { 7, 1, 5, 4 };
        var nums2 = new int[] { 9, 4, 3, 2 };
        var nums3 = new int[] { 1, 5, 2, 10 };
        System.out.println(sol.maximumDifferenceOpt(nums1));
        System.out.println(sol.maximumDifferenceOpt(nums2));
        System.out.println(sol.maximumDifferenceOpt(nums3));
    }

}
