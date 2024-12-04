// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution33 {

    // T: O(logn), S: O(1)
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target is in the left sorted portion
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Or the right half is sorted
            else {
                // Check if target is in the right sorted portion
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution33();
        var nums1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        var nums2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        var nums3 = new int[] { 1 };
        System.out.println(sol.search(nums1, 0)); // 4
        System.out.println(sol.search(nums2, 3)); // -1
        System.out.println(sol.search(nums3, 0)); // -1
    }

}
