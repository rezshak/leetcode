// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package RemoveDuplicatesFromSortedArray;

import java.util.HashSet;

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

    // T: O(n), S: O(n)
    public int removeDuplicates2(int[] nums) {
        var set = new HashSet<Integer>();
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!set.contains(n)) {
                nums[k] = n;
                k++;
            }
            set.add(n);
        }
        return k;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 1, 1, 2 };
        var nums2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(sol.removeDuplicates(nums1)); // [1,2]
        System.out.println(sol.removeDuplicates(nums2)); // [0,1,2,3,4]
    }

}
