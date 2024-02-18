// https://leetcode.com/problems/3sum/

package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // T: O(n^2), S: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++; high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        int[] nums2 = { 0, 1, 1 };
        int[] nums3 = { 0, 0, 0 };
        System.out.println(sol.threeSum(nums1));
        System.out.println(sol.threeSum(nums2));
        System.out.println(sol.threeSum(nums3));
    }

}
