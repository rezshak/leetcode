# https://leetcode.com/problems/counting-bits/

from typing import List


class Solution338:

    # T: O(nlogn), S: O(n)
    def countBits(self, n: int) -> List[int]:
        ans = [0] * (n + 1)
        for i in range(n + 1):
            ans[i] = self.count1Bits(i)
        return ans

    def count1Bits(self, n: int) -> int:
        count = 0
        while n != 0:
            if n & 1 == 1:
                count += 1
            n >>= 1
        return count


def main() -> None:
    sol = Solution338()
    print(sol.countBits(2))  # [0, 1, 1]
    print(sol.countBits(5))  # [0, 1, 1, 2, 1, 2]


if __name__ == "__main__":
    main()
