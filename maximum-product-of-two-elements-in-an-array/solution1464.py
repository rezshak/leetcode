# https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

from typing import List


class Solution1464:

    # T: O(n), S: O(1)
    def maxProduct(self, nums):
        a = float('-inf')
        b = float('-inf')
        for n in nums:
            if n > a:
                b = a
                a = n
            elif n > b:
                b = n
        return (a - 1) * (b - 1)

    # T: O(nlogn), S: O(1)
    def maxProductSort(self, nums):
        nums.sort()
        n = len(nums)
        max1, max2 = nums[n - 1], nums[n - 2]
        return (max1 - 1) * (max2 - 1)


def main():
    sol = Solution1464()
    nums1 = [3, 4, 5, 2]
    nums2 = [1, 5, 4, 5]
    nums3 = [3, 7]
    print(sol.maxProduct(nums1))       # 12
    print(sol.maxProductSort(nums1))   # 12
    print(sol.maxProduct(nums2))       # 16
    print(sol.maxProductSort(nums2))   # 16
    print(sol.maxProduct(nums3))       # 12
    print(sol.maxProductSort(nums3))   # 12


if __name__ == "__main__":
    main()
