// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/

import java.util.*;

class Solution2824 {

    // T: O(nlogn), S: O(1)
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1, count = 0;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    // T: O(n^2), S: O(1)
    public int countPairsBrute(List<Integer> nums, int target) {
        int n = nums.size(), count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    // T: O(n^2), S: O(n)
    public int countPairsMap(List<Integer> nums, int target) {
        var freqsMap = new HashMap<Integer, Integer>();
        int count = 0;
        for (int num : nums) {
            for (int key : freqsMap.keySet()) {
                if (num + key < target) {
                    count += freqsMap.get(key);
                }
            }
            freqsMap.put(num, freqsMap.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution2824();
        var nums1 = Arrays.asList(-1, 1, 2, 3, 1);
        var nums2 = Arrays.asList(-6, 2, 5, -2, -7, -1, 3);
        System.out.println(sol.countPairs(nums1, 2)); // 3
        System.out.println(sol.countPairsBrute(nums1, 2)); // 3
        System.out.println(sol.countPairsMap(nums1, 2)); // 3
        System.out.println(sol.countPairs(nums2, -2)); // 10
        System.out.println(sol.countPairsBrute(nums2, -2)); // 10
        System.out.println(sol.countPairsMap(nums2, -2)); // 10
    }

}
