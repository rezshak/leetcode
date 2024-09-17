// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;

class Solution128 {

    // T: O(n), S: O(n)
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int count = 1;
                while (set.contains(n + 1)) {
                    count++;
                    n++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        var sol = new Solution128();
        var nums1 = new int[] { 100, 4, 200, 1, 3, 2 };
        var nums2 = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(sol.longestConsecutive(nums1)); // 4
        System.out.println(sol.longestConsecutive(nums2)); // 9
    }

}
