// https://leetcode.com/problems/circular-array-loop/

class Solution457 {

    // T: O(n), O(1)
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            while (nums[fast] * nums[i] > 0 && nums[nextIndex(nums, fast)] * nums[i] > 0) {
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextIndex(nums, fast));
                if (slow == fast) {
                    if (slow == nextIndex(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }
            slow = i;
            int val = nums[i];
            while (nums[slow] * val > 0) {
                int next = nextIndex(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }

    public static void main(String[] args) {
        var sol = new Solution457();
        var nums1 = new int[] { 2, -1, 1, 2, 2 };
        var nums2 = new int[] { -1, -2, -3, -4, -5, 6 };
        var nums3 = new int[] { 1, -1, 5, 1, 4 };
        System.out.println(sol.circularArrayLoop(nums1)); // true
        System.out.println(sol.circularArrayLoop(nums2)); // false
        System.out.println(sol.circularArrayLoop(nums3)); // true
    }

}
