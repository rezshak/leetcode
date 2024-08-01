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
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        int n = arr.length;
        for (int num : arr) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        if (maxVal - minVal == 0) {
            return true;
        }
        if ((maxVal - minVal) % (n - 1) != 0) {
            return false;
        }
        int diff = (maxVal - minVal) / (n - 1);
        var set = new HashSet<Integer>();
        for (int num : arr) {
            if ((num - minVal) % diff != 0) {
                return false;
            }
            set.add(num);
        }
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
