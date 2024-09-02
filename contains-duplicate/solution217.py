# https://leetcode.com/problems/contains-duplicate/

from typing import List


class Solution217:

    # T: O(n), S: O(n)
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)

    # T: O(n log n), S: O(1)
    def containsDuplicateSort(self, nums: List[int]) -> bool:
        nums.sort()
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                return True
        return False


def main() -> None:
    sol = Solution217()
    nums1 = [1, 2, 3, 1]
    nums2 = [1, 2, 3, 4]
    print(sol.containsDuplicate(nums1))  # true
    print(sol.containsDuplicateSort(nums1))  # true
    print(sol.containsDuplicate(nums2))  # false
    print(sol.containsDuplicateSort(nums2))  # false


if __name__ == "__main__":
    main()
