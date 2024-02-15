// https://leetcode.com/problems/reverse-bits/description/

package ReverseBits;

public class Solution {

    public int reverseBits(int num) {
        var res = 0;
        var lsb = 0;
        for (var i = 31; i >= 0; i--) {
            lsb = num & 1;
            lsb <<= i;
            res |= lsb;
            num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        var num1 = Integer.parseInt("00000010100101000001111010011100", 2);
        var s = new Solution();
        System.out.println(s.reverseBits(num1)); // 964176192
    }

}
