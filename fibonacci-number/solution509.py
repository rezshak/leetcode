# https://leetcode.com/problems/fibonacci-number/

class Solution509:

    # T: O(n), S: O(1)
    def fib(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        fib, a, b = 0, 0, 1
        for i in range(2, n + 1):
            fib = a + b
            a = b
            b = fib
        return fib

    # T: O(n), S: O(n)
    def fibDp(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        dp = [0] * (n + 1)
        dp[0] = 0
        dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 2] + dp[i - 1]
        return dp[n]

    # T: O(n), S: O(n)
    def fibRecMemo(self, n: int) -> int:
        memo = {0: 0, 1: 1}
        return self.fibMemoHelper(n, memo)

    def fibMemoHelper(self, n: int, memo: dict) -> int:
        if n in memo:
            return memo[n]
        memo[n] = self.fibMemoHelper(
            n - 1, memo) + self.fibMemoHelper(n - 2, memo)
        return memo[n]

    # T: O(2^n), S: O(n)
    def fibRec(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        return self.fibRec(n - 1) + self.fibRec(n - 2)


def main() -> None:
    sol = Solution509()

    print(sol.fib(2))  # 1
    print(sol.fib(3))  # 2
    print(sol.fib(4))  # 3

    print(sol.fibDp(2))  # 1
    print(sol.fibDp(3))  # 2
    print(sol.fibDp(4))  # 3

    print(sol.fibRecMemo(0))  # 0
    print(sol.fibRecMemo(2))  # 1
    print(sol.fibRecMemo(3))  # 2
    print(sol.fibRecMemo(4))  # 3

    print(sol.fibRec(2))  # 1
    print(sol.fibRec(3))  # 2
    print(sol.fibRec(4))  # 3


if __name__ == "__main__":
    main()
