// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/

import java.util.*;

class Solution2200 {

    // T: O(n), S: O(n)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        var indices = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int from = Math.max(i - k, 0);
                int till = Math.min(i + k, n - 1);
                for (int j = from; j <= till; j++) {
                    indices.add(j);
                }
            }
        }
        var result = new ArrayList<Integer>(indices);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution2200();
        var nums1 = new int[] { 3, 4, 9, 1, 3, 9, 5 };
        var nums2 = new int[] { 2, 2, 2, 2, 2 };
        var nums3 = new int[] {};
        var nums4 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(sol.findKDistantIndices(nums1, 9, 1)); // [1,2,3,4,5,6]
        System.out.println(sol.findKDistantIndices(nums2, 2, 2)); // [0,1,2,3,4]
        System.out.println(sol.findKDistantIndices(nums3, 1, 1)); // []
        System.out.println(sol.findKDistantIndices(nums4, 6, 1)); // []
    }

}
