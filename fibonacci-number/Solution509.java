// https://leetcode.com/problems/fibonacci-number/

import java.util.*;

class Solution509 {

    // T: O(n), S: O(1)
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fib = 0, a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // T: O(n), S: O(n)
    public int fibDp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        var dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    // T: O(n), S: O(n)
    public int fibRecMemo(int n) {
        var memo = new HashMap<Integer, Integer>();
        memo.put(0, 0);
        memo.put(1, 1);
        return helper(n, memo);
    }

    private int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, helper(n - 1, memo) + helper(n - 2, memo));
        return memo.get(n);
    }

    // T: O(2^n), S: O(n)
    public int fibRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        var sol = new Solution509();

        System.out.println(sol.fib(2)); // 1
        System.out.println(sol.fib(3)); // 2
        System.out.println(sol.fib(4)); // 3

        System.out.println(sol.fibDp(2)); // 1
        System.out.println(sol.fibDp(3)); // 2
        System.out.println(sol.fibDp(4)); // 3

        System.out.println(sol.fibRecMemo(0)); // 1
        System.out.println(sol.fibRecMemo(2)); // 1
        System.out.println(sol.fibRecMemo(3)); // 2
        System.out.println(sol.fibRecMemo(4)); // 3

        System.out.println(sol.fibRec(2)); // 1
        System.out.println(sol.fibRec(3)); // 2
        System.out.println(sol.fibRec(4)); // 3
    }

}
