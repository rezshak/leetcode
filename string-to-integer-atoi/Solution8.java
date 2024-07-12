// https://leetcode.com/problems/string-to-integer-atoi/

class Solution8 {

    // T: O(n), S:O(1)
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < s.length() && (Character.isDigit(s.charAt(i)))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        var sol = new Solution8();
        System.out.println(sol.myAtoi("42")); // 42
        System.out.println(sol.myAtoi("   -42")); // -42
        System.out.println(sol.myAtoi("4193 with words")); // 4193
        System.out.println(sol.myAtoi("words and 987")); // 0
        System.out.println(sol.myAtoi("-91283472332")); // -2147483648
    }

}
