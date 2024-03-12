// https://leetcode.com/problems/max-consecutive-ones-iii/

package MaxConsecutiveOnesIII;

public class Solution {

    // T: O(n), S: O(1)
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = 0, zeros = 0;
        while (right < len) {
            if (nums[right] == 0) {
                zeros++;
            }
            right++;
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        var nums2 = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(sol.longestOnes(nums1, 2)); // 6
        System.out.println(sol.longestOnes(nums2, 3)); // 10
    }

}
