// https://leetcode.com/problems/monotonic-array/

class Solution896 {

    // T: O(n), S: O(1)
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        var sol = new Solution896();
        var nums1 = new int[] { 1, 2, 2, 3 };
        System.out.println(sol.isMonotonic(nums1)); // true
        var nums2 = new int[] { 6, 5, 4, 4 };
        System.out.println(sol.isMonotonic(nums2)); // true
        var nums3 = new int[] { 1, 3, 2 };
        System.out.println(sol.isMonotonic(nums3)); // false
    }

}
