# https://leetcode.com/problems/single-number/

from typing import List


class Solution136:

    # T: O(n), S: O(1)
    def singleNumber(self, nums: List[int]):
        res = 0
        for n in nums:
            res ^= n
        return res


def main() -> None:
    sol = Solution136()
    nums1 = [2, 2, 1]
    nums2 = [4, 1, 2, 1, 2]
    nums3 = [1]
    print(sol.singleNumber(nums1))  # 1
    print(sol.singleNumber(nums2))  # 4
    print(sol.singleNumber(nums3))  # 1


if __name__ == "__main__":
    main()
