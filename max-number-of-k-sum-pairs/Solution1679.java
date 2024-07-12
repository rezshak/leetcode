// https://leetcode.com/problems/max-number-of-k-sum-pairs/

import java.util.Arrays;
import java.util.HashMap;

class Solution1679 {

    // T: O(n log n), S: O(1)
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int maxOps = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == k) {
                maxOps++;
                left++;
                right--;
            } else if (currSum < k) {
                left++;
            } else {
                right--;
            }
        }
        return maxOps;
    }

    // T: O(n), S: O(n)
    public int maxOperationsMap(int[] nums, int k) {
        var counts = new HashMap<Integer, Integer>();
        int maxOps = 0;
        for (int n : nums) {
            int diff = k - n;
            if (counts.containsKey(diff) && counts.get(diff) > 0) {
                maxOps++;
                counts.put(diff, counts.get(diff) - 1);
            } else {
                counts.put(n, counts.getOrDefault(n, 0) + 1);
            }
        }
        return maxOps;
    }

    public static void main(String[] args) {
        var sol = new Solution1679();
        var nums1 = new int[] { 1, 2, 3, 4 };
        var nums2 = new int[] { 3, 1, 3, 4, 3 };
        System.out.println(sol.maxOperationsMap(nums1, 5)); // 2
        System.out.println(sol.maxOperations(nums1, 5)); // 2
        System.out.println(sol.maxOperationsMap(nums2, 6)); // 1
        System.out.println(sol.maxOperations(nums2, 6)); // 1
    }

}
