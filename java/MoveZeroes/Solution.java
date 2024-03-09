// https://leetcode.com/problems/move-zeroes/

package MoveZeroes;

import java.util.Arrays;

public class Solution {

    // T: O(n), S: O(1)
    public void moveZeros(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < len) {
            nums[left++] = 0;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 0, 1, 0, 3, 12 };
        var nums2 = new int[] { 0 };
        sol.moveZeros(nums1);
        sol.moveZeros(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

}
