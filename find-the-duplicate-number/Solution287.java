// https://leetcode.com/problems/find-the-duplicate-number/

import java.util.BitSet;

class Solution287 {

    // T: O(n), S: O(n)
    public int findDuplicate(int[] nums) {
        var set = new BitSet(nums.length);
        for (int n : nums) {
            if (set.get(n)) {
                return n;
            }
            set.set(n);
        }
        return -1;
    }

    // T: O(n), S: O(1)
    public int findDuplicateFloyd(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        var sol = new Solution287();
        var nums1 = new int[] { 1, 3, 4, 2, 2 };
        var nums2 = new int[] { 3, 1, 3, 4, 2 };
        var nums3 = new int[] { 3, 3, 3, 3, 3 };
        System.out.println(sol.findDuplicate(nums1)); // 2
        System.out.println(sol.findDuplicate(nums2)); // 3
        System.out.println(sol.findDuplicate(nums3)); // 3
        System.out.println(sol.findDuplicateFloyd(nums1)); // 2
        System.out.println(sol.findDuplicateFloyd(nums2)); // 3
        System.out.println(sol.findDuplicateFloyd(nums3)); // 3
    }

}
