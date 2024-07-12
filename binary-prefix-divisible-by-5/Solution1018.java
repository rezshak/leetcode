// https://leetcode.com/problems/binary-prefix-divisible-by-5/

import java.util.ArrayList;
import java.util.List;

class Solution1018 {

    // T: O(n), S: O(n)
    public List<Boolean> prefixesDivBy5(int[] nums) {
        var result = new ArrayList<Boolean>(nums.length);
        int dec = 0;
        for (int base2 : nums) {
            dec = (dec * 2 + base2) % 5;
            result.add(dec == 0);
        }
        return result;
    }

    // T: O(n), S: O(n)
    public List<Boolean> prefixesDivBy5Bitwise(int[] nums) {
        var result = new ArrayList<Boolean>(nums.length);
        int dec = 0;
        for (int bit : nums) {
            dec = ((dec << 1) + bit) % 5;
            result.add(dec == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution1018();
        var nums1 = new int[] { 0, 1, 1 };
        var nums2 = new int[] { 1, 1, 1 };
        System.out.println(sol.prefixesDivBy5(nums1)); // [true, false, false]
        System.out.println(sol.prefixesDivBy5(nums2)); // [false, false, false]
        System.out.println(sol.prefixesDivBy5Bitwise(nums1)); // [true, false, false]
        System.out.println(sol.prefixesDivBy5Bitwise(nums2)); // [false, false, false]
    }

}
