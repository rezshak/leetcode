// https://leetcode.com/problems/binary-prefix-divisible-by-5/

package BinaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // T: O(n), S: O(1)
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int base10 = 0;
        for (int base2 : nums) {
            base10 = ((base10 << 1) + base2) % 5;
            result.add(base10 == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = { 0, 1, 1 }; // [true,false,false]
        int[] nums2 = { 1, 1, 1 }; // [false,false,false]
        System.out.println(sol.prefixesDivBy5(nums1));
        System.out.println(sol.prefixesDivBy5(nums2));
    }

}
