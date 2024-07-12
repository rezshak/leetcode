// https://leetcode.com/problems/majority-element/

import java.util.HashMap;

class Solution169 {

    // T: O(n), S: O(n)
    public int majorityElement(int[] nums) {
        var freqs = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        int count = Integer.MIN_VALUE;
        int num = Integer.MIN_VALUE;
        for (var entry : freqs.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                num = entry.getKey();
            }
        }
        return num;
    }

    // T: O(n), S: O(1)
    public int majorityElement2(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        var sol = new Solution169();
        var nums1 = new int[] { 3, 2, 3 };
        var nums2 = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(sol.majorityElement(nums1)); // 3
        System.out.println(sol.majorityElement(nums2)); // 2
        System.out.println(sol.majorityElement2(nums1)); // 3
        System.out.println(sol.majorityElement2(nums2)); // 2
    }

}
