# https://leetcode.com/problems/house-robber-ii/

from typing import List


class Solution213:

    # T: O(n), S: O(1)
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]

        if len(nums) == 2:
            return max(nums[0], nums[1])

        max1 = self.rob_simple(nums, 0, len(nums) - 2)
        max2 = self.rob_simple(nums, 1, len(nums) - 1)

        return max(max1, max2)

    def rob_simple(self, nums: List[int], start: int, end: int) -> int:
        prev1 = max(nums[start], nums[start + 1])
        prev2 = nums[start]

        for i in range(start + 2, end + 1):
            curr = max(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = curr

        return prev1


def main() -> None:
    sol = Solution213()
    nums1 = [2, 3, 2]
    nums2 = [1, 2, 3, 1]
    nums3 = [1, 2, 3]
    nums4 = [0, 0]
    print(sol.rob(nums1))
    print(sol.rob(nums2))
    print(sol.rob(nums3))
    print(sol.rob(nums4))


if __name__ == "__main__":
    main()
