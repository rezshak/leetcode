# https://leetcode.com/problems/product-of-array-except-self/

from typing import List


class Solution238:

    # T: O(n), S: O(n)
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = [1] * n
        left = 1
        for i in range(n):
            prefix[i] = left
            left *= nums[i]

        postfix = [1] * n
        right = 1
        for i in range(n - 1, -1, -1):
            postfix[i] = right
            right *= nums[i]

        output = [1] * n
        for i in range(n):
            output[i] = prefix[i] * postfix[i]

        return output

    # T: O(n), S: O(1)
    def productExceptSelfOpt(self, nums: List[int]) -> List[int]:
        n = len(nums)
        output = [1] * n
        left, right = 1, 1

        for i in range(n):
            output[i] = left
            left *= nums[i]

        for i in range(n - 1, -1, -1):
            output[i] *= right
            right *= nums[i]

        return output

    # T: O(n), S: O(1)
    def productExceptSelfOpt2(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        left_product, right_product = 1, 1
        l, r = 0, n - 1
        while l < n and r >= 0:
            res[l] *= left_product
            res[r] *= right_product
            left_product *= nums[l]
            right_product *= nums[r]
            l += 1
            r -= 1
        return res


def main() -> None:
    sol = Solution238()
    nums1 = [1, 2, 3, 4]
    nums2 = [-1, 1, 0, -3, 3]
    print(sol.productExceptSelf(nums1))    # [24, 12, 8, 6]
    print(sol.productExceptSelfOpt(nums1))  # [24, 12, 8, 6]
    print(sol.productExceptSelfOpt2(nums1))  # [24, 12, 8, 6]
    print(sol.productExceptSelf(nums2))    # [0, 0, 9, 0, 0]
    print(sol.productExceptSelfOpt(nums2))  # [0, 0, 9, 0, 0]
    print(sol.productExceptSelfOpt2(nums2))  # [0, 0, 9, 0, 0]


if __name__ == "__main__":
    main()
