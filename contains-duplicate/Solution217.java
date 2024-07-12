// https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;

class Solution217 {

    // T: O(n), S: O(n)
    public boolean containsDuplicate(int[] nums) {
        var seen = new HashSet<Integer>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            }
            seen.add(n);
        }
        return false;
    }

    // T: O(n log n), S: O(1)
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution217();
        var nums1 = new int[] { 1, 2, 3, 1 };
        var nums2 = new int[] { 1, 2, 3, 4 };
        System.out.println(sol.containsDuplicate(nums1)); // true
        System.out.println(sol.containsDuplicateSort(nums1)); // true
        System.out.println(sol.containsDuplicate(nums2)); // false
        System.out.println(sol.containsDuplicateSort(nums2)); // false
    }

}
