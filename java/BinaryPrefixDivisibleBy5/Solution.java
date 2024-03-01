// https://leetcode.com/problems/binary-prefix-divisible-by-5/

package BinaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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
        var sol = new Solution();
        int[] nums1 = { 0, 1, 1 }; // [true,false,false]
        int[] nums2 = { 1, 1, 1 }; // [false,false,false]
        System.out.println(sol.prefixesDivBy5(nums1));
        System.out.println(sol.prefixesDivBy5(nums2));
        System.out.println(sol.prefixesDivBy5Bitwise(nums1));
        System.out.println(sol.prefixesDivBy5Bitwise(nums2));
    }

}
