# https://leetcode.com/problems/climbing-stairs/

class Solution70:

    # T: O(n^2), S: O(n)
    def climbStairsRec(self, n: int) -> int:
        if n < 3:
            return n
        return self.climbStairsRec(n - 1) + self.climbStairsRec(n - 2)

    # T: O(n), S: O(n)
    def climbStairsMemo(self, n: int) -> int:
        memo = [0] * (n + 1)
        return self.helperMemo(n, memo)

    def helperMemo(self, n: int, memo: list) -> int:
        if memo[n] > 0:
            return n
        if n < 3:
            memo[n] = n
            return n
        memo[n] = self.helperMemo(n - 1, memo) + self.helperMemo(n - 2, memo)
        return memo[n]

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

    # T: O(n), S: O(1)
    def climbStairsDpBottomUpOpt(self, n: int) -> int:
        if n < 3:
            return n
        a, b, sum = 1, 2, 0
        for i in range(3, n + 1):
            sum = a + b
            a = b
            b = sum
        return sum


def main() -> None:
    sol = Solution70()
    print(sol.climbStairsRec(3))  # 3
    print(sol.climbStairsMemo(3))  # 3
    print(sol.climbStairsDp(3))  # 3
    print(sol.climbStairsDpBottomUpOpt(3))  # 3
    print(sol.climbStairsRec(4))  # 5
    print(sol.climbStairsMemo(4))  # 5
    print(sol.climbStairsDp(4))  # 5
    print(sol.climbStairsDpBottomUpOpt(4))  # 5


if __name__ == "__main__":
    main()
