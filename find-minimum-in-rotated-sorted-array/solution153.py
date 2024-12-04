# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

from typing import List


class Solution153:

    # T: O(logn), S: O(1)
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        left, right = 0, n - 1

        if nums[right] > nums[0]:
            return nums[0]

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if nums[mid] < nums[mid - 1]:
                return nums[mid]

            if nums[mid] > nums[0]:
                left = mid + 1
            else:
                right = mid - 1

        return -1


def main() -> None:
    sol = Solution153()
    nums1 = [3, 4, 5, 1, 2]
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    nums3 = [11, 13, 15, 17]
    print(sol.findMin(nums1))  # 1
    print(sol.findMin(nums2))  # 0
    print(sol.findMin(nums3))  # 11


if __name__ == "__main__":
    main()
