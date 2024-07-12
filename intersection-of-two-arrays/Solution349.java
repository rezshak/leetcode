// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

class Solution349 {

    // T: O(n+m), S: O(n+m)
    public int[] intersection(int[] nums1, int[] nums2) {
        var seen = new HashSet<Integer>();
        for (int n : nums1) {
            seen.add(n);
        }
        var list = new ArrayList<Integer>();
        for (int n : nums2) {
            if (seen.contains(n)) {
                list.add(n);
                seen.remove(n);
            }
        }
        var result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution349();
        var nums1 = new int[] { 1, 2, 2, 1 };
        var nums2 = new int[] { 4, 9, 5 };
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2))); // [2]
        nums1 = new int[] { 4, 9, 5 };
        nums2 = new int[] { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2))); // [9,4]
    }

}
