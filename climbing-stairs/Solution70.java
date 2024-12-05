// https://leetcode.com/problems/climbing-stairs/

class Solution70 {

    // T: O(n), S: O(1)
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // T: O(n), S: O(n)
    public int climbStairsDp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // T: O(n), S: O(n)
    public int climbStairsMemo(int n) {
        var memo = new int[n + 1];
        return helperMemo(n, memo);
    }

    private int helperMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n < 3) {
            memo[n] = n;
            return n;
        }
        memo[n] = helperMemo(n - 1, memo) + helperMemo(n - 2, memo);
        return memo[n];
    }

    // T: O(n^2), S: O(n)
    public int climbStairsBrute(int n) {
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        var sol = new Solution70();
        System.out.println(sol.climbStairs(3)); // 3
        System.out.println(sol.climbStairsDp(3));
        System.out.println(sol.climbStairsMemo(3));
        System.out.println(sol.climbStairsBrute(3));
        System.out.println(sol.climbStairs(4)); // 5
        System.out.println(sol.climbStairsDp(4)); // 5
        System.out.println(sol.climbStairsMemo(4)); // 5
        System.out.println(sol.climbStairsBrute(4)); // 5
    }

}
