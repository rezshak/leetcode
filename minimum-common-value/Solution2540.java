// https://leetcode.com/problems/minimum-common-value/

import java.util.HashSet;

class Solution2540 {

    // T: O(n+m), S: O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (idx1 < n1 && idx2 < n2) {
            int num1 = nums1[idx1], num2 = nums2[idx2];
            if (num1 == num2) {
                return num1;
            } else if (num1 < num2) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return -1;
    }

    // T: O(n+m), S: O(n)
    public int getCommonSet(int[] nums1, int[] nums2) {
        var seen = new HashSet<Integer>();
        for (int n : nums1) {
            seen.add(n);
        }
        for (int n : nums2) {
            if (seen.contains(n)) {
                return n;
            }
        }
        return -1;
    }

    // T: O(nlogm), S: O(1)
    public int getCommonBinarySearch(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return getCommonBinarySearch(nums2, nums1);
        }
        for (int n : nums1) {
            if (binarySearch(nums2, n)) {
                return n;
            }
        }
        return -1;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution2540();
        var nums1 = new int[] { 1, 2, 3 };
        var nums2 = new int[] { 2, 4 };
        System.out.println(sol.getCommon(nums1, nums2)); // 2
        System.out.println(sol.getCommonSet(nums1, nums2)); // 2
        System.out.println(sol.getCommonBinarySearch(nums1, nums2)); // 2
        nums1 = new int[] { 1, 2, 3, 6 };
        nums2 = new int[] { 2, 3, 4, 5 };
        System.out.println(sol.getCommon(nums1, nums2)); // 2
        System.out.println(sol.getCommonSet(nums1, nums2)); // 2
        System.out.println(sol.getCommonBinarySearch(nums1, nums2)); // 2
        nums1 = new int[] { 1, 3, 5 };
        nums2 = new int[] { 2, 4, 6 };
        System.out.println(sol.getCommon(nums1, nums2)); // -1
        System.out.println(sol.getCommonSet(nums1, nums2)); // -1
        System.out.println(sol.getCommonBinarySearch(nums1, nums2)); // -1
    }

}
