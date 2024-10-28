# https://leetcode.com/problems/subsets/

from typing import List


class Solution78:

    # T: O(n2^n), S: O(n)
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        curr = []
        self.backtrack(0, nums, result, curr)
        return result

    def backtrack(self, start: int, nums: List[int], result: List[List[int]], curr: List[int]):
        result.append(curr[:])
        for i in range(start, len(nums)):
            curr.append(nums[i])
            self.backtrack(i + 1, nums, result, curr)
            curr.pop()

    # T: O(2^n), S: O(n2^n)
    def subsetsBitmask(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        total_subsets = 1 << n  # 2^n total subsets
        result = []
        for i in range(total_subsets):
            curr = []
            for j in range(n):
                # If the j-th bit in i is set, include nums[j] in the current subset.
                if i & (1 << j):
                    curr.append(nums[j])
            result.append(curr)
        return result


def main() -> None:
    sol = Solution78()
    nums1 = [1, 2, 3]
    nums2 = [0]
    # [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    print(sol.subsets(nums1))
    print(sol.subsets(nums2))       # [[],[0]]
    # [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    print(sol.subsetsBitmask(nums1))
    print(sol.subsetsBitmask(nums2))  # [[],[0]]


if __name__ == "__main__":
    main()
