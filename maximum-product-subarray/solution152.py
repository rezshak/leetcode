# https://leetcode.com/problems/maximum-product-subarray/

from typing import List


class Solution152:

    # T: O(n), S: O(1)
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        max_product = nums[0]
        current_product = 1

        for i in range(n):
            current_product *= nums[i]
            max_product = max(max_product, current_product)

            if current_product == 0:
                current_product = 1

        current_product = 1
        for i in range(n - 1, -1, -1):
            current_product *= nums[i]
            max_product = max(max_product, current_product)

            if current_product == 0:
                current_product = 1

        return max_product

    # T: O(n), S: O(1)
    def maxProductKadane(self, nums: List[int]) -> int:
        if not nums:
            return 0

        max_so_far = nums[0]
        min_so_far = nums[0]
        result = max_so_far

        for i in range(1, len(nums)):
            curr = nums[i]
            temp_max = max(curr, max(max_so_far * curr, min_so_far * curr))
            temp_min = min(curr, min(max_so_far * curr, min_so_far * curr))

            max_so_far = temp_max
            min_so_far = temp_min

            result = max(result, max_so_far)

        return result

    # T: O(n^2), S: O(1)
    def maxProductBrute(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        result = nums[0]
        for i in range(n):
            cur = nums[i]
            result = max(result, cur)
            for j in range(i + 1, n):
                cur *= nums[j]
                result = max(result, cur)
        return result


def main() -> None:
    sol = Solution152()
    nums1 = [2, 3, -2, 4]
    nums2 = [-2, 0, -1]
    print(sol.maxProduct(nums1))       # 6
    print(sol.maxProductKadane(nums1))  # 6
    print(sol.maxProductBrute(nums1))  # 6
    print(sol.maxProduct(nums2))       # 0
    print(sol.maxProductKadane(nums2))  # 0
    print(sol.maxProductBrute(nums2))  # 0


if __name__ == "__main__":
    main()
