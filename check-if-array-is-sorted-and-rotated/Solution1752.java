// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution1752 {

    // T: O(n), S: O(1)
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        var sol = new Solution1752();
        var nums1 = new int[] { 3, 4, 5, 1, 2 };
        var nums2 = new int[] { 2, 1, 3, 4 };
        var nums3 = new int[] { 1, 2, 3 };
        System.out.println(sol.check(nums1)); // true
        System.out.println(sol.check(nums2)); // false
        System.out.println(sol.check(nums3)); // true
    }

}
