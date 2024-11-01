# https://leetcode.com/problems/permutations/

from typing import List


class Solution46:

    # T: O(n*n!), S: O(n*n!)
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        curr = []
        self.backtrack(nums, result, curr)
        return result

    def backtrack(self, nums, result, curr):
        if len(curr) == len(nums):
            result.append(curr[:])
            return
        for num in nums:
            if num not in curr:
                curr.append(num)
                self.backtrack(nums, result, curr)
                curr.pop()

    # T: O(n*n!), S: O(n*n!)
    def permuteIterative(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for num in nums:
            curr = []
            for perm in result:
                for i in range(len(perm) + 1):
                    new_perm = perm[:i] + [num] + perm[i:]
                    curr.append(new_perm)
            result = curr
        return result


def main() -> None:
    sol = Solution46()
    nums1 = [1, 2, 3]
    nums2 = [0, 1]
    nums3 = [1]
    # [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    print(sol.permute(nums1))
    print(sol.permute(nums2))          # [[0,1],[1,0]]
    print(sol.permute(nums3))          # [[1]]
    # [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    print(sol.permuteIterative(nums1))
    print(sol.permuteIterative(nums2))  # [[0,1],[1,0]]
    print(sol.permuteIterative(nums3))  # [[1]]


if __name__ == "__main__":
    main()
