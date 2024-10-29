# https://leetcode.com/problems/subsets/

from typing import List


class Solution78:

    # T: O(n2^n), S: O(n)
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        curr = []
        self.backtrack(nums, 0, curr, result)
        return result

    def backtrack(self, nums: List[int], start: int, curr: List[int], result: List[List[int]]):
        result.append(curr[:])
        for i in range(start, len(nums)):
            curr.append(nums[i])
            self.backtrack(nums, i + 1, curr, result)
            curr.pop()

    # T: O(n2^n), S: O(n2^n)
    def subsetsBitmask(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        totalSubsets = 1 << n  # 2^n total subsets
        result = []
        for i in range(totalSubsets):
            curr = []
            for j in range(n):
                # If the j-th bit in i is set, include nums[j] in the current subset.
                if i & (1 << j):
                    curr.append(nums[j])
            result.append(curr)
        return result

    # T: O(2^n), S: O(n2^n)
    def subsetsIterative(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            size = len(result)
            for i in range(size):
                newSubset = result[i] + [num]
                result.append(newSubset)
        return result

    # T: O(2^n), S: O(n2^n)
    def subsetsBrute(self, nums: List[int]) -> List[List[int]]:
        result = []
        curr = []
        self.generateSubsets(nums, 0, curr, result)
        return result

    def generateSubsets(self, nums: List[int], index: int, curr: List[int], result: List[List[int]]):
        if index == len(nums):
            result.append(curr[:])
            return
        self.generateSubsets(nums, index + 1, curr, result)
        curr.append(nums[index])
        self.generateSubsets(nums, index + 1, curr, result)
        curr.pop()


def main() -> None:
    sol = Solution78()
    nums1 = [1, 2, 3]
    nums2 = [0]
    print(sol.subsets(nums1))  # [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    print(sol.subsetsBitmask(nums1))
    print(sol.subsetsIterative(nums1))
    print(sol.subsetsBrute(nums1))
    print(sol.subsets(nums2))          # [[],[0]]


if __name__ == "__main__":
    main()
