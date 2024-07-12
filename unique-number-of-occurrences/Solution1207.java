// https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.HashMap;
import java.util.HashSet;

class Solution1207 {

    // T: O(n), S: O(n)
    public boolean uniqueOccurrences(int[] arr) {
        var freqs = new HashMap<Integer, Integer>();
        for (int n : arr) {
            freqs.put(n, freqs.getOrDefault(n, 0) + 1);
        }
        var counts = new HashSet<Integer>();
        for (int val : freqs.values()) {
            if (counts.contains(val)) {
                return false;
            }
            counts.add(val);
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution1207();
        var nums1 = new int[] { 1, 2, 2, 1, 1, 3 };
        var nums2 = new int[] { 1, 2 };
        var nums3 = new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(sol.uniqueOccurrences(nums1)); // true
        System.out.println(sol.uniqueOccurrences(nums2)); // false
        System.out.println(sol.uniqueOccurrences(nums3)); // true
    }

}
