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
        var set = new HashSet<Integer>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int n : arr) {
            minVal = Math.min(minVal, n);
            maxVal = Math.max(maxVal, n);
            set.add(n);
        }
        if (set.size() == 1) {
            return true;
        }
        if (set.size() != arr.length) {
            return false;
        }
        int diff = (maxVal - minVal) / (arr.length - 1);
        if (diff == 0) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(minVal + i * diff)) {
                return false;
            }
        }
        return true;
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
