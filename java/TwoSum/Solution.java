// https://leetcode.com/problems/two-sum/

package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

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
        var s = new Solution();
        var nums1 = new int[] { 2, 7, 11, 15 };
        var target1 = 9;
        System.out.println(Arrays.toString(s.twoSum(nums1, target1)));
        var nums2 = new int[] { 3, 2, 4 };
        var target2 = 6;
        System.out.println(Arrays.toString(s.twoSum(nums2, target2)));
        var nums3 = new int[] { 3, 3 };
        var target3 = 6;
        System.out.println(Arrays.toString(s.twoSum(nums3, target3)));
    }

}
