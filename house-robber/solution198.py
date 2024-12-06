# https://leetcode.com/problems/house-robber/

from typing import List


class Solution198:

    # T: O(n), S: O(1)
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev1 = max(nums[0], nums[1])
        prev2 = nums[0]

        for i in range(2, len(nums)):
            curr = max(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = curr

        return prev1

    # T: O(n), S: O(n)
    def robDp(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        if n == 1:
            return nums[0]

        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, n):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])

        return dp[n - 1]

    # T: O(n), S: O(n)
    def robMemo(self, nums: List[int]) -> int:
        memo = {}
        return self.helper(nums, 0, memo)

    def helper(self, nums, i, memo):
        if i >= len(nums):
            return 0
        if i in memo:
            return memo[i]
        memo[i] = max(self.helper(nums, i + 1, memo),
                      nums[i] + self.helper(nums, i + 2, memo))
        return memo[i]

    # T: O(2^n), S: O(n)
    def robBrute(self, nums):
        return self.dfs(nums, 0)

    def dfs(self, nums, i):
        if i >= len(nums):
            return 0
        return max(self.dfs(nums, i + 1), nums[i] + self.dfs(nums, i + 2))


def main() -> None:
    sol = Solution198()

    nums = [1, 2, 3, 1]
    print(sol.rob(nums))        # 4
    print(sol.robDp(nums))      # 4
    print(sol.robMemo(nums))    # 4
    print(sol.robBrute(nums))    # 4

    nums = [2, 7, 9, 3, 1]
    print(sol.rob(nums))        # 12
    print(sol.robDp(nums))      # 12
    print(sol.robMemo(nums))    # 12
    print(sol.robBrute(nums))    # 12


if __name__ == "__main__":
    main()
