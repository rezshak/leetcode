# https://leetcode.com/problems/sort-an-array/

from typing import List


class Solution912:

    # Merge sort
    # T: O(n log n), S: O(n)
    def sortArray(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) <= 1:
            return nums

        mid = len(nums) // 2
        nums1 = nums[:mid]
        nums2 = nums[mid:]

        self.sortArray(nums1)
        self.sortArray(nums2)
        self.merge(nums, nums1, nums2)

        return nums

    def merge(self, nums: List[int], nums1: List[int], nums2: List[int]) -> None:
        idx = idx1 = idx2 = 0
        len1, len2 = len(nums1), len(nums2)

        while idx1 < len1 and idx2 < len2:
            if nums1[idx1] <= nums2[idx2]:
                nums[idx] = nums1[idx1]
                idx1 += 1
            else:
                nums[idx] = nums2[idx2]
                idx2 += 1
            idx += 1

        while idx1 < len1:
            nums[idx] = nums1[idx1]
            idx1 += 1
            idx += 1

        while idx2 < len2:
            nums[idx] = nums2[idx2]
            idx2 += 1
            idx += 1


def main() -> None:
    sol = Solution912()
    nums1 = [5, 2, 3, 1]
    print(sol.sortArray(nums1))
    nums2 = [5, 1, 1, 2, 0, 0]
    print(sol.sortArray(nums2))


if __name__ == "__main__":
    main()
