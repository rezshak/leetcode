// https://leetcode.com/problems/single-number/

class Solution136 {

    // T: O(n), S: O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution136();
        var nums1 = new int[] { 2, 2, 1 };
        var nums2 = new int[] { 4, 1, 2, 1, 2 };
        var nums3 = new int[] { 1 };
        System.out.println(sol.singleNumber(nums1)); // 1
        System.out.println(sol.singleNumber(nums2)); // 4
        System.out.println(sol.singleNumber(nums3)); // 1
    }

}
