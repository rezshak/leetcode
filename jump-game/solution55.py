# https://leetcode.com/problems/jump-game/

from typing import List


class Solution55:

    # T: O(n), S: O(1)
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 0:
            return False

        n = len(nums)
        max_jump = 0

        for i in range(n):
            if i > max_jump:
                return False
            max_jump = max(max_jump, i + nums[i])
            if max_jump >= n - 1:
                return True

        return False


def main():
    sol = Solution55()

    nums1 = [2, 3, 1, 1, 4]
    print(sol.canJump(nums1))  # true

    nums2 = [3, 2, 1, 0, 4]
    print(sol.canJump(nums2))  # false

    nums3 = [0]
    print(sol.canJump(nums3))  # true

    nums4 = [5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0]
    print(sol.canJump(nums4))  # true


if __name__ == "__main__":
    main()
