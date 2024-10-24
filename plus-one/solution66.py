# https://leetcode.com/problems/plus-one/

from typing import List


class Solution66:

    # T: O(n), S: O(n)
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        for i in range(n - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0
        return [1] + [0] * n


def main() -> None:
    sol = Solution66()
    nums1 = [1, 2, 3]
    nums2 = [4, 3, 2, 1]
    nums3 = [9]
    print(sol.plusOne(nums1))
    print(sol.plusOne(nums2))
    print(sol.plusOne(nums3))


if __name__ == "__main__":
    main()
