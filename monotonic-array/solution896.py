# https://leetcode.com/problems/monotonic-array/

from typing import List


class Solution896:

    # T: O(n), S: O(1)
    def isMonotonic(self, nums: List[int]) -> bool:
        increasing = True
        decreasing = True
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                increasing = False
            if nums[i] < nums[i + 1]:
                decreasing = False
        return increasing or decreasing


def main() -> None:
    sol = Solution896()
    nums1 = [1, 2, 2, 3]
    print(sol.isMonotonic(nums1))  # True
    nums2 = [6, 5, 4, 4]
    print(sol.isMonotonic(nums2))  # True
    nums3 = [1, 3, 2]
    print(sol.isMonotonic(nums3))  # False


if __name__ == "__main__":
    main()
