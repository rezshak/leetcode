# https://leetcode.com/problems/minimum-common-value/

from typing import List


class Solution2540:

    # T: O(n+m), S: O(1)
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)
        idx1, idx2 = 0, 0
        while idx1 < n1 and idx2 < n2:
            num1, num2 = nums1[idx1], nums2[idx2]
            if num1 == num2:
                return num1
            elif num1 < num2:
                idx1 += 1
            else:
                idx2 += 1
        return -1

    # T: O(n+m), S: O(n)
    def getCommonSet(self, nums1: List[int], nums2: List[int]) -> int:
        seen = set(nums1)
        for n in nums2:
            if n in seen:
                return n
        return -1

    # T: O(nlogm), S: O(1)
    def getCommonBinarySearch(self, nums1: List[int], nums2: List[int]) -> int:
        if len(nums2) > len(nums1):
            return self.getCommonBinarySearch(nums2, nums1)
        for n in nums1:
            if self.binarySearch(nums2, n):
                return n
        return -1

    def binarySearch(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                return True
        return False


def main() -> None:
    sol = Solution2540()
    nums1 = [1, 2, 3]
    nums2 = [2, 4]
    print(sol.getCommon(nums1, nums2))  # 2
    print(sol.getCommonSet(nums1, nums2))  # 2
    print(sol.getCommonBinarySearch(nums1, nums2))  # 2
    nums1 = [1, 2, 3, 6]
    nums2 = [2, 3, 4, 5]
    print(sol.getCommon(nums1, nums2))  # 2
    print(sol.getCommonSet(nums1, nums2))  # 2
    print(sol.getCommonBinarySearch(nums1, nums2))  # 2
    nums1 = [1, 3, 5]
    nums2 = [2, 4, 6]
    print(sol.getCommon(nums1, nums2))  # -1
    print(sol.getCommonSet(nums1, nums2))  # -1
    print(sol.getCommonBinarySearch(nums1, nums2))  # -1


if __name__ == "__main__":
    main()
