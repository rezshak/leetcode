# https://leetcode.com/problems/maximum-difference-between-increasing-elements/

from typing import List


class Solution2016:

    # T: O(n), S: O(n)
    def maximumDifference(self, nums: List[int]) -> int:
        n = len(nums)
        right_maxes = [0] * n
        right_maxes[-1] = nums[-1]
        for i in range(n - 2, -1, -1):
            right_maxes[i] = max(right_maxes[i + 1], nums[i])
        max_diff = -1
        for i in range(n):
            if right_maxes[i] > nums[i]:
                max_diff = max(max_diff, right_maxes[i] - nums[i])
        return max_diff

    # T: O(n), S: O(1)
    def maximumDifferenceOpt(self, nums: List[int]) -> int:
        n = len(nums)
        right_max = nums[-1]
        max_diff = -1
        for i in range(n - 2, -1, -1):
            if nums[i] < right_max:
                max_diff = max(max_diff, right_max - nums[i])
            right_max = max(right_max, nums[i])
        return max_diff


def main() -> None:
    sol = Solution2016()
    nums1 = [7, 1, 5, 4]
    nums2 = [9, 4, 3, 2]
    nums3 = [1, 5, 2, 10]
    print(sol.maximumDifference(nums1))  # 4
    print(sol.maximumDifference(nums2))  # -1
    print(sol.maximumDifference(nums3))  # 9
    print(sol.maximumDifferenceOpt(nums1))  # 4
    print(sol.maximumDifferenceOpt(nums2))  # -1
    print(sol.maximumDifferenceOpt(nums3))  # 9


if __name__ == "__main__":
    main()
