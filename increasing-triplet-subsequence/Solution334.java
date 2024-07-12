// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution334 {

    // T: O(n), S: O(1)
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= a) {
                a = n;
            } else if (n > a && n <= b) {
                b = n;
            } else if (n > b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution334();
        var nums1 = new int[] { 1, 2, 3, 4, 5 };
        var nums2 = new int[] { 5, 4, 3, 2, 1 };
        var nums3 = new int[] { 2, 1, 5, 0, 4, 6 };
        var nums4 = new int[] { 2, 4, -2, -3 };
        System.out.println(sol.increasingTriplet(nums1)); // true
        System.out.println(sol.increasingTriplet(nums2)); // false
        System.out.println(sol.increasingTriplet(nums3)); // true
        System.out.println(sol.increasingTriplet(nums4)); // false
    }

}
