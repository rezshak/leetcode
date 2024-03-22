// https://leetcode.com/problems/next-greater-element-i/

package NextGreaterElementI;

import java.util.Arrays;

class Solution {

    // T: O(n*m), S: O(1)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums1[i];
            int idx = indexOf(nums2, num);
            res[i] = nextGreater(nums2, num, idx + 1);
        }
        return res;
    }

    // T: O(n), S: O(1)
    private int indexOf(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }

    // T: O(n), S: O(1)
    private int nextGreater(int[] nums, int num, int idx) {
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > num) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 4, 1, 2 };
        var nums2 = new int[] { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2))); // -1,3,-1
        nums1 = new int[] { 2, 4 };
        nums2 = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2))); // 3,-1
    }

}
