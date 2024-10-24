// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

import java.util.*;

class Solution1502 {

    // T: O(nlogn), S: O(1)
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }

    // T: O(n), S: O(n)
    public boolean canMakeArithmeticProgressionSet(int[] arr) {
        int n = arr.length;
        if (n <= 2) {
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Calculate the common difference
        if ((max - min) % (n - 1) != 0) {
            return false;
        }
        int diff = (max - min) / (n - 1);

        // If the difference is zero, all elements must be the same
        if (diff == 0) {
            return true;
        }

        var set = new HashSet<Integer>();
        for (int num : arr) {
            // Check if each number is in the arithmetic progression sequence
            if ((num - min) % diff != 0) {
                return false;
            }
            set.add(num);
        }

        // Check if all numbers in the arithmetic sequence are present
        return set.size() == n;
    }

    public static void main(String[] args) {
        var sol = new Solution1502();
        var arr1 = new int[] { 3, 5, 1 };
        var arr2 = new int[] { 1, 2, 4 };
        System.out.println(sol.canMakeArithmeticProgression(arr1)); // true
        System.out.println(sol.canMakeArithmeticProgressionSet(arr1)); // true
        System.out.println(sol.canMakeArithmeticProgression(arr2)); // false
        System.out.println(sol.canMakeArithmeticProgressionSet(arr2)); // false
    }

}
