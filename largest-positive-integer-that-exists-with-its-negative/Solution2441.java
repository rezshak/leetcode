// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

import java.util.*;

class Solution2441 {

    // T: O(n), S: O(n)
    public int findMaxK(int[] nums) {
        var seen = new HashSet<Integer>();
        for (int n : nums) {
            seen.add(n);
        }
        int ans = -1;
        for (int n : seen) {
            if (n > 0 && seen.contains(-n)) {
                ans = Math.max(ans, n);
            }
        }
        return ans;
    }

    // T: O(n), S: O(n)
    public int findMaxKOnePass(int[] nums) {
        var seen = new HashSet<Integer>();
        int ans = -1;
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (absNum > ans && seen.contains(-num)) {
                ans = absNum;
            }
            seen.add(num);
        }
        return ans;
    }

    // T: O(n), S: O(1)
    public int findMaxKBitset(int[] nums) {
        var pos = new BitSet(1001);
        var neg = new BitSet(1001);
        for (int num : nums) {
            if (num > 0) {
                pos.set(num);
            } else if (num < 0) {
                neg.set(-num);
            }
        }
        for (int n = 1000; n > 0; n--) {
            if (pos.get(n) && neg.get(n)) {
                return n;
            }
        }
        return -1;
    }

    // T: O(nlogn), S: O(1)
    public int findMaxKBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int ans = -1, left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == 0) {
                ans = Math.max(ans, nums[right]);
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    // T: O(n^2), S: O(1)
    public int findMaxKBrute(int[] nums) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int n1 = nums[i];
            for (int j = i + 1; j < n; j++) {
                int n2 = nums[j];
                if (n1 == -n2) {
                    ans = Math.max(ans, Math.abs(n1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution2441();
        var nums1 = new int[] { -1, 2, -3, 3 };
        var nums2 = new int[] { -1, 10, 6, 7, -7, 1 };
        var nums3 = new int[] { -10, 8, 6, 7, -2, -3 };
        System.out.println(sol.findMaxK(nums1)); // 3
        System.out.println(sol.findMaxKOnePass(nums1)); // 3
        System.out.println(sol.findMaxKBitset(nums1)); // 3
        System.out.println(sol.findMaxKBinarySearch(nums1)); // 3
        System.out.println(sol.findMaxKBrute(nums1)); // 3
        System.out.println(sol.findMaxK(nums2)); // 7
        System.out.println(sol.findMaxKOnePass(nums2)); // 7
        System.out.println(sol.findMaxKBitset(nums2)); // 7
        System.out.println(sol.findMaxKBinarySearch(nums2)); // 7
        System.out.println(sol.findMaxKBrute(nums2)); // 7
        System.out.println(sol.findMaxK(nums3)); // -1
        System.out.println(sol.findMaxKOnePass(nums3)); // -1
        System.out.println(sol.findMaxKBitset(nums3)); // -1
        System.out.println(sol.findMaxKBinarySearch(nums3)); // -1
        System.out.println(sol.findMaxKBrute(nums3)); // -1
    }

}
