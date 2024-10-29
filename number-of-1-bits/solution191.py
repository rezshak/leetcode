# https://leetcode.com/problems/number-of-1-bits/

class Solution191:

    # T: O(1), S: O(1)
    def hammingWeight(self, n: int) -> int:
        count = 0
        for _ in range(32):
            if n & 1:
                count += 1
            n >>= 1
        return count


def main():
    sol = Solution191()
    n1 = 0b00000000000000000000000000001011
    n2 = 0b00000000000000000000000010000000
    print(sol.hammingWeight(n1))  # 3
    print(sol.hammingWeight(n2))  # 1


if __name__ == "__main__":
    main()
