// https://leetcode.com/problems/3sum/

import java.util.*;

class Solution15 {

    // T: O(n^2), S: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        var set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int num1 = nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                int num2 = nums[left];
                int num3 = nums[right];
                int currSum = num1 + num2 + num3;
                if (currSum == 0) {
                    var triplet = List.of(num1, num2, num3);
                    set.add(triplet);
                    left++;
                    right--;
                    continue;
                }
                if (currSum < 0) {
                    left++;
                } else if (currSum > 0) {
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    // T: O(n^2), S: O(n)
    public List<List<Integer>> threeSumOpt(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                if (currSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (currSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution15();
        var nums1 = new int[] { -1, 0, 1, 2, -1, -4 };
        var nums2 = new int[] { 0, 1, 1 };
        var nums3 = new int[] { 0, 0, 0 };
        System.out.println(sol.threeSum(nums1)); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSumOpt(nums1)); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSum(nums2)); // []
        System.out.println(sol.threeSumOpt(nums2)); // []
        System.out.println(sol.threeSum(nums3)); // [[0,0,0]]
        System.out.println(sol.threeSumOpt(nums3)); // [[0,0,0]]
    }

}
