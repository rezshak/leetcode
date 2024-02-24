// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

package FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class Solution {

    // T: O(n), S: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        var result = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // T: O(n), S: O(n)
    public List<Integer> findDisappearedNumbersBitSet(int[] nums) {
        int n = nums.length;
        var bs = new BitSet(n);
        for (int num : nums)
            bs.set(num);
        var result = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (!bs.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(sol.findDisappearedNumbers(nums1)); // [5,6]
        int[] nums2 = { 1, 1 };
        System.out.println(sol.findDisappearedNumbers(nums2)); // [2]
    }

}
