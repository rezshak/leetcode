// https://leetcode.com/problems/divide-two-integers/

class Solution29 {

    // T: O(log n), S: O(1)
    public int divide(int dividend, int divisor) {
        // Handle edge cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }

        // Convert to positive and track sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to handle MIN_VALUE case
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // While dividend is greater than or equal to divisor
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;

            // Find largest multiple of divisor <= dividend using bit shifting
            while (absDividend >= (temp << 1)) {
                temp <<= 1; // Double the temp value
                multiple <<= 1; // Double the multiple
            }

            // Subtract the largest multiple found
            absDividend -= temp;
            result += multiple;
        }

        // Apply sign to result
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        var sol = new Solution29();
        System.out.println(sol.divide(10, 3)); // 3
        System.out.println(sol.divide(7, -3)); // -2
    }

}
