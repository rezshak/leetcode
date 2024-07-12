// https://leetcode.com/problems/search-insert-position/

class Solution35 {

    // T: O(log(n)), S: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var sol = new Solution35();
        var nums = new int[] { 1, 3, 5, 6 };
        System.out.println(sol.searchInsert(nums, 5)); // 2
        System.out.println(sol.searchInsert(nums, 2)); // 1
        System.out.println(sol.searchInsert(nums, 7)); // 4
    }

}
