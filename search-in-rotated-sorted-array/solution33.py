# https://leetcode.com/problems/search-in-rotated-sorted-array/

from typing import List


class Solution33:

    # T: O(logn), S: O(1)
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid

            if nums[left] <= nums[mid]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target > nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1


def main() -> None:
    sol = Solution33()
    nums1 = [4, 5, 6, 7, 0, 1, 2]
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    nums3 = [1]
    print(sol.search(nums1, 0))  # 4
    print(sol.search(nums2, 3))  # -1
    print(sol.search(nums3, 0))  # -1


if __name__ == "__main__":
    main()
