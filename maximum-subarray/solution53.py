# https://leetcode.com/problems/maximum-subarray/

from typing import List


class Solution53:

    # T: O(n^2), S: O(1)
    def maxSubArrayBrute(self, nums: List[int]) -> int:
        n = len(nums)
        max_sum = nums[0]
        for i in range(n):
            curr_sum = 0
            for j in range(i, n):
                curr_sum += nums[j]
                max_sum = max(max_sum, curr_sum)
        return max_sum

    # T: O(n), S: O(n)
    def maxSubArrayDpOpt(self, nums: List[int]) -> int:
        dp = nums[:]
        for i in range(1, len(nums)):
            dp[i] = max(nums[i], nums[i] + dp[i - 1])
        return max(dp)

    # T: O(n), S: O(1)
    def maxSubArrayKadane(self, nums: List[int]) -> int:
        max_sum = nums[0]
        curr_sum = nums[0]
        for i in range(1, len(nums)):
            curr_sum = max(nums[i], curr_sum + nums[i])
            max_sum = max(max_sum, curr_sum)
        return max_sum


def main():
    sol = Solution53()
    nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    nums2 = [1]
    nums3 = [5, 4, -1, 7, 8]

    print(sol.maxSubArrayBrute(nums1))
    print(sol.maxSubArrayDpOpt(nums1))
    print(sol.maxSubArrayKadane(nums1))
    print()

    print(sol.maxSubArrayBrute(nums2))
    print(sol.maxSubArrayDpOpt(nums2))
    print(sol.maxSubArrayKadane(nums2))
    print()

    print(sol.maxSubArrayBrute(nums3))
    print(sol.maxSubArrayDpOpt(nums3))
    print(sol.maxSubArrayKadane(nums3))


if __name__ == "__main__":
    main()
