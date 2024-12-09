// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution153 {

    // T: O(logn), S: O(1)
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int left = 0, right = n - 1;

        // If last element is greater than first, array is not rotated
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than its next element,
            // next element is the minimum
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // If mid element is less than its previous element,
            // mid element is the minimum
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // Decide which half to search
            // If mid element is greater than first element,
            // minimum is in right half
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
            // Otherwise, minimum is in left half
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution153();
        var nums1 = new int[] { 3, 4, 5, 1, 2 };
        var nums2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        var nums3 = new int[] { 11, 13, 15, 17 };
        System.out.println(sol.findMin(nums1)); // 1
        System.out.println(sol.findMin(nums2)); // 0
        System.out.println(sol.findMin(nums3)); // 11
    }

}
