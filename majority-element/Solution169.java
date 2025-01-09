// https://leetcode.com/problems/majority-element/

import java.util.Arrays;
import java.util.HashMap;

class Solution169 {

    // T: O(n), S: O(1)
    // Sort the array and return the middle element
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // T: O(n), S: O(n)
    // Use a hashmap to count occurrences of each element
    public int majorityElementMap(int[] nums) {
        var counts = new HashMap<Integer, Integer>();
        int n = nums.length;

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // Won't reach here given problem constraints
    }

    // T: O(n), S: O(1)
    // Boyer-Moore Voting Algorithm
    public int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        var sol = new Solution169();
        var nums1 = new int[] { 3, 2, 3 };
        var nums2 = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(sol.majorityElement(nums1)); // 3
        System.out.println(sol.majorityElement(nums2)); // 2
        System.out.println(sol.majorityElementMap(nums1)); // 3
        System.out.println(sol.majorityElementMap(nums2)); // 2
        System.out.println(sol.majorityElementBoyerMoore(nums1)); // 3
        System.out.println(sol.majorityElementBoyerMoore(nums2)); // 2
    }

}
