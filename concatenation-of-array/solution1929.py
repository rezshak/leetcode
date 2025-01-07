# https://leetcode.com/problems/concatenation-of-array/

from typing import List


class Solution1929:

    # T: O(n), S: O(1)
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums + nums

    # T: O(n), S: O(1)
    def getConcatenation2(self, nums: List[int]) -> List[int]:
        return nums * 2


def main() -> None:
    sol = Solution1929
    testCaeses = [
        [1, 2, 1],
        [1, 3, 2, 1],
        [1, 2, 3, 4]
    ]
    for i, nums in enumerate(testCaeses):
        print(sol.getConcatenation(sol, nums))

    print(sol.getConcatenation2(sol, [1, 2, 1]))


if __name__ == "__main__":
    main()
