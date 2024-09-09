# https://leetcode.com/problems/richest-customer-wealth/

class Solution1672:

    # T: O(n), S: O(1)
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        max_wealth = 0
        for account in accounts:
            current_wealth = sum(account)
            max_wealth = max(max_wealth, current_wealth)
        return max_wealth


def main() -> None:
    sol = Solution1672()
    accounts1 = [[1, 2, 3], [3, 2, 1]]
    accounts2 = [[1, 5], [7, 3], [3, 5]]
    accounts3 = [[2, 8, 7], [7, 1, 3], [1, 9, 5]]
    print(sol.maximumWealth(accounts1))  # Output: 6
    print(sol.maximumWealth(accounts2))  # Output: 10
    print(sol.maximumWealth(accounts3))  # Output: 17


if __name__ == "__main__":
    main()
