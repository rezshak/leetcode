// https://leetcode.com/problems/base-7/

package Base7;

class Solution {

    // T: O(log(n)), S: O(1)
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        var sb = new StringBuilder();
        int absNum = Math.abs(num);
        while (absNum > 0) {
            int base7Digit = absNum % 7;
            sb.insert(0, base7Digit);
            absNum = absNum / 7;
        }
        if (num < 0) sb.insert(0, "-");
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int num1 = 100;
        System.out.println(sol.convertToBase7(num1)); // 202
        int num2 = -7;
        System.out.println(sol.convertToBase7(num2)); // -10
    }

}
