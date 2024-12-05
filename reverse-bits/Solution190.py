# https://leetcode.com/problems/reverse-bits/

class Solution190:

    # T: O(1), S: O(1)
    def reverseBits(self, num: int) -> int:
        res = 0
        for i in range(32):
            lsb = num & 1
            res = (res << 1) | lsb
            num >>= 1
        return res


def main() -> None:
    sol = Solution190()
    num1 = int("00000010100101000001111010011100", 2)
    print(sol.reverseBits(num1))  # 964176192


if __name__ == "__main__":
    main()
