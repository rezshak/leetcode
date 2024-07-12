// https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.*;

class Solution350 {

    // T: O(n+m), S: O(min(n+m))
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        var freqMap = getFreqCount(nums1);
        int k = 0;
        for (int n : nums2) {
            int count = freqMap.getOrDefault(n, 0);
            if (count > 0) {
                nums2[k++] = n;
                freqMap.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(nums2, 0, k);
    }

    private Map<Integer, Integer> getFreqCount(int[] nums) {
        var freqMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        var sol = new Solution350();
        var nums1 = new int[] { 1, 2, 2, 1 };
        var nums2 = new int[] { 2, 2 };
        System.out.println(Arrays.toString(sol.intersect(nums1, nums2))); // [2,2]
        nums1 = new int[] { 4, 9, 5 };
        nums2 = new int[] { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(sol.intersect(nums1, nums2))); // [4,9]
    }

}
