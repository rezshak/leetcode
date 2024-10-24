# https://leetcode.com/problems/sign-of-the-product-of-an-array/

from typing import List


class Solution1822:

    # T: O(n), S: O(1)
    def arraySign(self, nums: List[int]) -> int:
        prod = 1
        for n in nums:
            if n > 0:
                prod *= 1
            elif n < 0:
                prod *= -1
            else:
                return 0
        return prod

    # T: O(n), S: O(1)
    def arraySignNegCount(self, nums: List[int]) -> int:
        neg_count = 0
        for n in nums:
            if n == 0:
                return 0
            if n < 0:
                neg_count += 1
        return 1 if (neg_count & 1) == 0 else -1


def main():
    sol = Solution1822()
    nums1 = [-1, -2, -3, -4, 3, 2, 1]
    nums2 = [1, 5, 0, 2, -3]
    nums3 = [-1, 1, -1, 1, -1]
    nums4 = [9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24]
    print(sol.arraySign(nums1))  # 1
    print(sol.arraySignNegCount(nums1))  # 1
    print(sol.arraySign(nums2))  # 0
    print(sol.arraySignNegCount(nums2))  # 0
    print(sol.arraySign(nums3))  # -1
    print(sol.arraySignNegCount(nums3))  # -1
    print(sol.arraySign(nums4))  # -1
    print(sol.arraySignNegCount(nums4))  # -1


if __name__ == "__main__":
    main()
