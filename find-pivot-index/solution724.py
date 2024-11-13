# https://leetcode.com/problems/find-pivot-index/

from typing import List


class Solution724:

    # T: O(n), S: O(1)
    def pivotIndex(self, nums: List[int]) -> int:
        total_sum = sum(nums)
        left_sum = 0
        for i, num in enumerate(nums):
            right_sum = total_sum - left_sum - num
            if left_sum == right_sum:
                return i
            left_sum += num

        return -1


def main() -> None:
    sol = Solution724()
    nums1 = [1, 7, 3, 6, 5, 6]
    nums2 = [1, 2, 3]
    nums3 = [2, 1, -1]
    print(sol.pivotIndex(nums1))  # 3
    print(sol.pivotIndex(nums2))  # -1
    print(sol.pivotIndex(nums3))  # 0


if __name__ == "__main__":
    main()
