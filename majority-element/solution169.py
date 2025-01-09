# https://leetcode.com/problems/majority-element/

from typing import List
from collections import defaultdict


class Solution169:

    # T: O(n), S: O(1)
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

    # T: O(n), S: O(n)
    def majorityElementMap(self, nums: List[int]) -> int:
        counts = defaultdict(int)
        n = len(nums)

        for num in nums:
            counts[num] += 1
            if counts[num] > n // 2:
                return num

        return -1

    # T: O(n), S: O(1)
    def majorityElementBoyerMoore(self, nums: List[int]) -> int:
        count = 0
        candidate = 0

        for num in nums:
            if count == 0:
                candidate = num
            count += 1 if num == candidate else -1

        return candidate


def main() -> None:
    sol = Solution169()
    nums1 = [3, 2, 3]
    nums2 = [2, 2, 1, 1, 1, 2, 2]
    print(sol.majorityElement(nums1))           # 3
    print(sol.majorityElement(nums2))           # 2
    print(sol.majorityElementMap(nums1))        # 3
    print(sol.majorityElementMap(nums2))        # 2
    print(sol.majorityElementBoyerMoore(nums1))  # 3
    print(sol.majorityElementBoyerMoore(nums2))  # 2


if __name__ == "__main__":
    main()
