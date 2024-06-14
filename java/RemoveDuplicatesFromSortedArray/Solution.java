// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package RemoveDuplicatesFromSortedArray;

class Solution {

    // T: O(n), S: O(1)
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 1, 1, 2 };
        var nums2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(sol.removeDuplicates(nums1)); // [1,2]
        System.out.println(sol.removeDuplicates(nums2)); // [0,1,2,3,4]
    }

}
