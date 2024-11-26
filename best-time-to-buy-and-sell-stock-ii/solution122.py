# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution122:

    # T: O(n), S: O(1)
    def maxProfit(self, prices: list[int]) -> int:
        max_profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                curr_profit = prices[i] - prices[i - 1]
                max_profit += curr_profit
        return max_profit


def main() -> None:
    sol = Solution122()
    prices1 = [7, 1, 5, 3, 6, 4]
    prices2 = [1, 2, 3, 4, 5]
    prices3 = [7, 6, 4, 3, 1]
    print(sol.maxProfit(prices1))  # 7
    print(sol.maxProfit(prices2))  # 4
    print(sol.maxProfit(prices3))  # 0


if __name__ == "__main__":
    main()
