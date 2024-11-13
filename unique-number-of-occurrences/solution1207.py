# https://leetcode.com/problems/unique-number-of-occurrences/

from collections import Counter
from typing import List


class Solution1207:

    # T: O(n), S: O(n)
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        freqs = Counter(arr)
        counts = set()
        for val in freqs.values():
            if val in counts:
                return False
            counts.add(val)
        return True


def main() -> None:
    sol = Solution1207()
    nums1 = [1, 2, 2, 1, 1, 3]
    nums2 = [1, 2]
    nums3 = [-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]
    print(sol.uniqueOccurrences(nums1))  # true
    print(sol.uniqueOccurrences(nums2))  # false
    print(sol.uniqueOccurrences(nums3))  # true


if __name__ == "__main__":
    main()
