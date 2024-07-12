// https://leetcode.com/problems/number-of-distinct-averages/

import java.util.Arrays;
import java.util.HashSet;

class Solution2465 {

    // T: O(n log n), S: O(n)
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        var set = new HashSet<Double>();
        while (left < right) {
            int min = nums[left++];
            int max = nums[right--];
            double avg = (double) (min + max) / 2;
            set.add(avg);
        }
        return set.size();
    }

    public static void main(String[] args) {
        var sol = new Solution2465();
        var nums1 = new int[] { 4, 1, 4, 0, 3, 5 };
        var nums2 = new int[] { 1, 100 };
        System.out.println(sol.distinctAverages(nums1)); // 2
        System.out.println(sol.distinctAverages(nums2)); // 1
    }

}
