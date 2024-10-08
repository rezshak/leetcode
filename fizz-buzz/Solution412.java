// https://leetcode.com/problems/fizz-buzz/

import java.util.*;

class Solution412 {

    // T: O(n), S: O(n)
    public List<String> fizzBuzz(int n) {
        var result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution412();
        System.out.println(sol.fizzBuzz(3));
        System.out.println(sol.fizzBuzz(5));
        System.out.println(sol.fizzBuzz(15));
    }

}
