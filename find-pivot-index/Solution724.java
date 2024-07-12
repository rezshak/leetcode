// https://leetcode.com/problems/find-pivot-index/

class Solution724 {

    // T: O(n), S: O(1)
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution724();
        var nums1 = new int[] { 1, 7, 3, 6, 5, 6 };
        var nums2 = new int[] { 1, 2, 3 };
        var nums3 = new int[] { 2, 1, -1 };
        System.out.println(sol.pivotIndex(nums1)); // 3
        System.out.println(sol.pivotIndex(nums2)); // -1
        System.out.println(sol.pivotIndex(nums3)); // 0
    }

}
