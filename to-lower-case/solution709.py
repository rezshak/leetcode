# https://leetcode.com/problems/to-lower-case/

DIFF = ord('a') - ord('A')  # 32
UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
LOWER = "abcdefghijklmnopqrstuvwxyz"
MAP = {UPPER[i]: LOWER[i] for i in range(26)}


class Solution709:

    # T: O(n), S: O(n)
    def toLowerCase(self, s: str) -> str:
        result = []
        for ch in s:
            if 'A' <= ch <= 'Z':
                result.append(chr(ord(ch) + DIFF))
            else:
                result.append(ch)
        return ''.join(result)

    # T: O(n), S: O(n)
    def toLowerCaseMap(self, s: str) -> str:
        result = []
        for ch in s:
            result.append(MAP.get(ch, ch))
        return ''.join(result)


def main() -> None:
    sol = Solution709()
    s1 = "Hello"
    s2 = "here"
    s3 = "LOVELY"
    print(sol.toLowerCase(s1))      # hello
    print(sol.toLowerCaseMap(s1))  # hello
    print(sol.toLowerCase(s2))      # here
    print(sol.toLowerCaseMap(s2))  # here
    print(sol.toLowerCase(s3))      # lovely
    print(sol.toLowerCaseMap(s3))  # lovely


if __name__ == "__main__":
    main()
