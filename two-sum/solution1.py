# https://leetcode.com/problems/two-sum/

from typing import List


class Solution1:

    # T: O(n), S: O(n)
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indices = dict()
        for i, n in enumerate(nums):
            diff = target - n
            if diff in indices:
                return [indices[diff], i]
            indices[n] = i

        return []


def main() -> None:
    sol = Solution1()
    nums1 = [2, 7, 11, 15]
    nums2 = [3, 2, 4]
    nums3 = [3, 3]
    print(sol.twoSum(nums1, 9))  # [0, 1]
    print(sol.twoSum(nums2, 6))  # [1,2]
    print(sol.twoSum(nums3, 6))  # [0, 1]


if __name__ == "__main__":
    main()
