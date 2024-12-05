# https://leetcode.com/problems/sum-of-two-integers/

class Solution371:

    # T: O(1), S: O(1)
    def getSum(self, a: int, b: int) -> int:
        while b != 0:
            carry = a & b
            a = a ^ b
            b = carry << 1
        return a


def main() -> None:
    sol = Solution371()
    print(sol.getSum(1, 2))  # 3
    print(sol.getSum(2, 3))  # 5


if __name__ == "__main__":
    main()
