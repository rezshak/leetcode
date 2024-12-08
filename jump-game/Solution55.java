// https://leetcode.com/problems/jump-game/

class Solution55 {

    // Greedy approach
    // T: O(n), S: O(1)
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int maxJump = 0; // // The furthest index we can reach

        // Iterate through the array
        for (int i = 0; i <= maxJump; i++) {
            // Update the furthest reachable index
            maxJump = Math.max(maxJump, i + nums[i]);

            // If we can reach or pass the last index, return true
            if (maxJump >= n - 1) {
                return true;
            }
        }

        // If we can't reach beyond our current max reach, return false
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution55();

        var nums1 = new int[] { 2, 3, 1, 1, 4 };
        System.out.println(sol.canJump(nums1)); // true

        var nums2 = new int[] { 3, 2, 1, 0, 4 };
        System.out.println(sol.canJump(nums2)); // false

        var nums3 = new int[] { 0 };
        System.out.println(sol.canJump(nums3)); // true

        var nums4 = new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
        System.out.println(sol.canJump(nums4)); // true
    }

}
