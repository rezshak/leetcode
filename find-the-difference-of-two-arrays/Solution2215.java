// https://leetcode.com/problems/find-the-difference-of-two-arrays/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution2215 {

    // T: O(n), S: O(n)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();
        for (int n : nums1)
            set1.add(n);
        for (int n : nums2)
            set2.add(n);
        for (int n : set1) {
            if (!set2.contains(n)) {
                list1.add(n);
            }
        }
        for (int n : set2) {
            if (!set1.contains(n)) {
                list2.add(n);
            }
        }
        return List.of(list1, list2);
    }

    public static void main(String[] args) {
        var sol = new Solution2215();
        var nums1 = new int[] { 1, 2, 3, 2 };
        var nums2 = new int[] { 2, 4, 6, 4 };
        System.out.println(sol.findDifference(nums1, nums2));
    }

}
