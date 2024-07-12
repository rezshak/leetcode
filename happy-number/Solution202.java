// https://leetcode.com/problems/happy-number/

import java.util.HashSet;

class Solution202 {

    // T: O(log n), S: O(log n)
    public boolean isHappy(int num) {
        var seen = new HashSet<Integer>();
        while (!seen.contains(num) && num != 1) {
            seen.add(num);
            num = squaredDigitsSum(num);
        }
        return num == 1;
    }

    // T: O(log n), S: O(1)
    public boolean isHappyOpt(int num) {
        int slow = num, fast = squaredDigitsSum(num);
        while (fast != 1 && fast != slow) {
            slow = squaredDigitsSum(slow);
            fast = squaredDigitsSum(squaredDigitsSum(fast));
        }
        return fast == 1;
    }

    // T: O(log n), S: O(1)
    private int squaredDigitsSum(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            int squared = digit * digit;
            result += squared;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution202();
        System.out.println(sol.isHappy(19)); // true
        System.out.println(sol.isHappy(2)); // false
        System.out.println(sol.isHappyOpt(19)); // true
        System.out.println(sol.isHappyOpt(2)); // false
    }

}
