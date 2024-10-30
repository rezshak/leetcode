# https://leetcode.com/problems/climbing-stairs/

class Solution70:

    # T: O(n), S: O(1)
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n
        a, b, sum = 1, 2, 0
        for i in range(3, n + 1):
            sum = a + b
            a = b
            b = sum
        return sum

    # T: O(n), S: O(n)
    def climbStairsDp(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

    # T: O(n), S: O(n)
    def climbStairsMemo(self, n: int) -> int:
        memo = [0] * (n + 1)
        return self.helperMemo(0, n, memo)

    def helperMemo(self, i: int, n: int, memo: list) -> int:
        if i > n:
            return 0
        if i == n:
            return 1
        if memo[i] > 0:
            return memo[i]
        memo[i] = self.helperMemo(i + 1, n, memo) + \
            self.helperMemo(i + 2, n, memo)
        return memo[i]

    # T: O(n^2), S: O(n)
    def climbStairsBrute(self, n: int) -> int:
        return self.helperBrute(0, n)

    def helperBrute(self, i, n: int) -> int:
        if i > n:
            return 0
        if i == n:
            return 1
        return self.helperBrute(i + 1, n) + self.helperBrute(i + 2, n)


def main() -> None:
    sol = Solution70()
    print(sol.climbStairs(3))  # 3
    print(sol.climbStairsDp(3))  # 3
    print(sol.climbStairsMemo(3))  # 3
    print(sol.climbStairsBrute(3))  # 3
    print(sol.climbStairs(4))  # 5
    print(sol.climbStairsDp(4))  # 5
    print(sol.climbStairsMemo(4))  # 5
    print(sol.climbStairsBrute(4))  # 5


if __name__ == "__main__":
    main()
