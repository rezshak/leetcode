// https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

import java.util.Arrays;

class Solution1385 {

    // T: O(nm), S: O(1)
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int absDiff = Math.abs(arr1[i] - arr2[j]);
                if (absDiff <= d) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    // T: O(nlogn), S: O(1)
    public int findTheDistanceValueOpt(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int n : arr1) {
            if (isDistanceValue(n, arr2, d)) {
                count++;
            }
        }
        return count;
    }

    private boolean isDistanceValue(int n, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(n - arr2[mid]) <= d) {
                return false;
            } else if (arr2[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution1385();
        var arr1 = new int[] { 4, 5, 8 };
        var arr2 = new int[] { 10, 9, 1, 8 };
        System.out.println(sol.findTheDistanceValue(arr1, arr2, 2)); // 2
        System.out.println(sol.findTheDistanceValueOpt(arr1, arr2, 2)); // 2
        arr1 = new int[] { 1, 4, 2, 3 };
        arr2 = new int[] { -4, -3, 6, 10, 20, 30 };
        System.out.println(sol.findTheDistanceValue(arr1, arr2, 3)); // 2
        System.out.println(sol.findTheDistanceValueOpt(arr1, arr2, 3)); // 2
        arr1 = new int[] { 2, 1, 100, 3 };
        arr2 = new int[] { -5, -2, 10, -3, 7 };
        System.out.println(sol.findTheDistanceValue(arr1, arr2, 6)); // 1
        System.out.println(sol.findTheDistanceValueOpt(arr1, arr2, 6)); // 1
    }

}
