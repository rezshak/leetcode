// https://leetcode.com/problems/sum-of-two-integers/

class Solution371 {

    // T: O(1), S: O(1)
    public int getSum(int a, int b) {
        // Iterate till there is no carry
        while (b != 0) {
            // Carry now contains common set bits of a and b
            int carry = a & b;
            // Sum of bits of a and b where at least one of the bits is not set
            a = a ^ b;
            // Carry is shifted by one so that adding it to a gives the required sum
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        var sol = new Solution371();
        System.out.println(sol.getSum(1, 2)); // 3
        System.out.println(sol.getSum(2, 3)); // 5
    }

}
