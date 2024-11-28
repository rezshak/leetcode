// https://leetcode.com/problems/number-of-1-bits/

class Solution191 {

    // T: O(1), S: O(1)
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    // T: O(1), S: O(1)
    public int hammingWeightMaskShifting(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution191();
        int n1 = 00000000000000000000000000001011;
        int n2 = 00000000000000000000000010000000;
        System.out.println(sol.hammingWeight(n1)); // 3
        System.out.println(sol.hammingWeightMaskShifting(n1)); // 3
        System.out.println(sol.hammingWeight(n2)); // 1
        System.out.println(sol.hammingWeightMaskShifting(n2)); // 1
    }

}
