// https://leetcode.com/problems/find-the-array-concatenation-value/

class Solution2562 {

    // T: O(n), S: O(1)
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0L;
        for (int left = 0, right = nums.length - 1; left <= right; left++, right--) {
            var numStr = "";
            if (left != right) {
                numStr = String.valueOf(nums[left]) + String.valueOf(nums[right]);
            } else {
                numStr = String.valueOf(nums[left]);
            }
            ans += Long.parseLong(numStr);
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution2562();
        var nums1 = new int[] { 7, 52, 2, 4 };
        var nums2 = new int[] { 5, 14, 13, 8, 12 };
        System.out.println(sol.findTheArrayConcVal(nums1)); // 596
        System.out.println(sol.findTheArrayConcVal(nums2)); // 673
    }

}
