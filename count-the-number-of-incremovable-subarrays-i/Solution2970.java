// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

class Solution2970 {

    // T: O(n^2), S: O(n)
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isStrictlyIncreasing(removeSubarray(nums, i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] removeSubarray(int[] nums, int start, int end) {
        int n = nums.length, idx = 0;
        var result = new int[n - (end - start + 1)];
        for (int i = 0; i < start; i++) {
            result[idx++] = nums[i];
        }
        for (int i = end + 1; i < n; i++) {
            result[idx++] = nums[i];
        }
        return result;
    }

    private boolean isStrictlyIncreasing(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution2970();
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 6, 5, 7, 8 };
        int[] nums3 = { 8, 7, 6, 6 };
        System.out.println(sol.incremovableSubarrayCount(nums1)); // 10
        System.out.println(sol.incremovableSubarrayCount(nums2)); // 7
        System.out.println(sol.incremovableSubarrayCount(nums3)); // 3
    }

}
