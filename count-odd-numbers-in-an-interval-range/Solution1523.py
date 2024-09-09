# https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution1523:

    # T: O(1), S: O(1)
    def countOdds(self, low: int, high: int) -> int:
        if (low & 1) == 0:
            low += 1
        return 0 if low > high else (high - low) // 2 + 1

    # T: O(h-l), S: O(1)
    def countOddsBrute(self, low: int, high: int) -> int:
        count = 0
        while low <= high:
            if (low & 1) == 1:
                count += 1
            low += 1
        return count


def main() -> None:
    sol = Solution1523()
    print(sol.countOdds(3, 7))  # 3
    print(sol.countOddsBrute(3, 7))  # 3
    print(sol.countOdds(8, 10))  # 1
    print(sol.countOddsBrute(8, 10))  # 1


if __name__ == "__main__":
    main()
