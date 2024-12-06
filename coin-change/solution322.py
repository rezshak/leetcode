# https://leetcode.com/problems/coin-change/

import math
from typing import List


class Solution322:

    # T: O(n^amt), S: O(amt)
    def coinChangeRec(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        return self.dfsRec(coins, amount)

    def dfsRec(self, coins, remainingAmount):
        if remainingAmount < 0:
            return -1
        if remainingAmount == 0:
            return 0

        minCoins = math.inf

        for coin in coins:
            subResult = self.dfsRec(coins, remainingAmount - coin)
            if subResult != -1:
                minCoins = min(minCoins, subResult + 1)

        return -1 if minCoins == math.inf else minCoins

    # T: O(n*amt), S: O(amt)
    def coinChangeRecMemo(self, coins: List[int], amount: int) -> int:
        memo = {}
        return self.dfsRecMemo(coins, amount, memo)

    def dfsRecMemo(self, coins, remainingAmount, memo):
        if remainingAmount in memo:
            return memo[remainingAmount]

        if remainingAmount < 0:
            return -1
        if remainingAmount == 0:
            return 0

        minCoins = math.inf

        for coin in coins:
            subResult = self.dfsRecMemo(coins, remainingAmount - coin, memo)
            if subResult != -1:
                minCoins = min(minCoins, subResult + 1)

        result = -1 if minCoins == math.inf else minCoins
        memo[remainingAmount] = result
        return result

    # T: O(n*amt), S: O(amt)
    def coinChangeDpBottomUp(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0

        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        return -1 if dp[amount] > amount else dp[amount]


def main() -> None:
    sol = Solution322()
    coins1 = [1, 2, 5]
    amount1 = 11
    print(sol.coinChangeRec(coins1, amount1))        # 3 (5 + 5 + 1)
    print(sol.coinChangeRecMemo(coins1, amount1))    # 3 (5 + 5 + 1)
    print(sol.coinChangeDpBottomUp(coins1, amount1))  # 3 (5 + 5 + 1)
    coins2 = [2]
    amount2 = 3
    print(sol.coinChangeRec(coins2, amount2))        # -1
    print(sol.coinChangeRecMemo(coins2, amount2))    # -1
    print(sol.coinChangeDpBottomUp(coins2, amount2))  # -1
    coins3 = [1]
    amount3 = 0
    print(sol.coinChangeRec(coins3, amount3))        # 0
    print(sol.coinChangeRecMemo(coins3, amount3))    # 0
    print(sol.coinChangeDpBottomUp(coins3, amount3))  # 0


if __name__ == "__main__":
    main()
