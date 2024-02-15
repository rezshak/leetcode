// https://leetcode.com/problems/majority-element/description/

package MajorityElement;

import java.util.HashMap;

class Solution {

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
        var s = new Solution();
        var nums1 = new int[] { 3, 2, 3 };
        var nums2 = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(s.majorityElement(nums1));
        System.out.println(s.majorityElement(nums2));
        System.out.println(s.majorityElement2(nums1));
        System.out.println(s.majorityElement2(nums2));
    }

}
