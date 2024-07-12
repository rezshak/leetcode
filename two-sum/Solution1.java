// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;

class Solution1 {

    // T: O(n), S: O(n)
    public int[] twoSum(int[] nums, int target) {
        var idxMap = new HashMap<Integer, Integer>(); // num, idx
        for (var i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (idxMap.containsKey(diff)) {
                return new int[] { idxMap.get(diff), i };
            }
            idxMap.put(nums[i], i);
        }

        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        var sol = new Solution1();
        var nums1 = new int[] { 2, 7, 11, 15 };
        var nums2 = new int[] { 3, 2, 4 };
        var nums3 = new int[] { 3, 3 };
        System.out.println(Arrays.toString(sol.twoSum(nums1, 9))); // [0, 1]
        System.out.println(Arrays.toString(sol.twoSum(nums2, 6))); // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(nums3, 6))); // [0, 1]
    }

}
