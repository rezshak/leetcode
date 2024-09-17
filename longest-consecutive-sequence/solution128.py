# https://leetcode.com/problems/longest-consecutive-sequence/

from typing import List


class Solution128:

    # T: O(n), S: O(n)
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest = 0

        for n in nums:
            if n - 1 not in num_set:
                count = 1
                while n + 1 in num_set:
                    count += 1
                    n += 1
                longest = max(longest, count)

        return longest


def main() -> None:
    sol = Solution128()
    nums1 = [100, 4, 200, 1, 3, 2]
    nums2 = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    print(sol.longestConsecutive(nums1))  # 4
    print(sol.longestConsecutive(nums2))  # 9


if __name__ == "__main__":
    main()
