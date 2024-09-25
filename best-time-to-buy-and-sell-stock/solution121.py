# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

from typing import List


class Solution121:

    # T: O(n), S: (1)
    def maxProfit(self, prices: List[int]) -> int:
        l, r, n = 0, 1, len(prices)
        res = 0
        while r < n:
            if prices[l] < prices[r]:
                res = max(res, prices[r] - prices[l])
            else:
                l = r

            r += 1

        return res


def main() -> None:
    sol = Solution121()
    prices1 = [7, 1, 5, 3, 6, 4]
    prices2 = [7, 6, 4, 3, 1]
    print(sol.maxProfit(prices1))  # 5
    print(sol.maxProfit(prices2))  # 0


if __name__ == "__main__":
    main()
