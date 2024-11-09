// https://leetcode.com/problems/sort-colors/

import java.util.Arrays;

class Solution75 {

    // T: O(n), S: O(1)
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int n : nums) {
            if (n == 0) {
                cnt0++;
            } else if (n == 1) {
                cnt1++;
            } else if (n == 2) {
                cnt2++;
            }
        }
        int i = 0;
        while (cnt0 > 0) {
            nums[i++] = 0;
            cnt0--;
        }
        while (cnt1 > 0) {
            nums[i++] = 1;
            cnt1--;
        }
        while (cnt2 > 0) {
            nums[i++] = 2;
            cnt2--;
        }
    }

    // T: O(n), S: O(1)
    public void sortColorsOnePass(int[] nums) {
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            } else if (nums[p1] == 1) {
                p1++;
            } else {
                swap(nums, p2, p1);
                p2--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution75();
        var nums1 = new int[] { 2, 0, 2, 1, 1, 0 };
        var nums2 = new int[] { 2, 0, 1 };
        var nums3 = new int[] { 0, 2, 1 };
        sol.sortColorsOnePass(nums1);
        sol.sortColorsOnePass(nums2);
        sol.sortColors(nums3);
        System.out.println(Arrays.toString(nums1)); // [0,0,1,1,2,2]
        System.out.println(Arrays.toString(nums2)); // [0,1,2]
        System.out.println(Arrays.toString(nums3)); // [0,1,2]
    }

}
