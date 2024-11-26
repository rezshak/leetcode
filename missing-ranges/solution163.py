# https://leetcode.com/problems/missing-ranges/

from typing import List


class Solution163:

    # T: O(n), S: O(1)
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        result = []
        n = len(nums)

        if n == 0:
            result.append([lower, upper])
            return result
        if nums[0] > lower:
            result.append([lower, nums[0] - 1])

        # Handle ranges between elements
        for i in range(n - 1):
            curr, next = nums[i], nums[i + 1]
            if next - curr > 1:
                result.append([curr + 1, next - 1])

        if nums[n - 1] < upper:
            result.append([nums[n - 1] + 1, upper])

        return result

    # T: O(n), S: O(1)
    def findMissingRangesOpt(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        result = []
        prev = lower - 1
        for num in nums:
            if num > prev + 1:
                result.append([prev + 1, num - 1])
            prev = num

        if prev < upper:
            result.append([prev + 1, upper])

        return result


def main() -> None:
    sol = Solution163()
    nums1 = [0, 1, 3, 50, 75]
    nums2 = [-1]
    # [[2,2],[4,49],[51,74],[76,99]]
    print(sol.findMissingRanges(nums1, 0, 99))
    print(sol.findMissingRangesOpt(nums1, 0, 99))
    print(sol.findMissingRanges(nums2, -1, -1))  # []
    print(sol.findMissingRangesOpt(nums2, -1, -1))  # []


if __name__ == "__main__":
    main()
