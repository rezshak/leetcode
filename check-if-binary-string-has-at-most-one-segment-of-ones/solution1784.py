# https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

class Solution1784:

    # T: O(n), S: O(1)
    def checkOnesSegment(self, s: str) -> bool:
        n = len(s)
        for i in range(n - 1):
            curr, next = s[i], s[i + 1]
            if curr == '0' and next == '1':
                return False

        return True

    def checkOnesSegmentBuiltin(self, s: str) -> bool:
        return '01' not in s


def main() -> None:
    sol = Solution1784()
    print(sol.checkOnesSegment("1001"))  # False
    print(sol.checkOnesSegmentBuiltin("1001"))  # False
    print(sol.checkOnesSegment("110"))  # True
    print(sol.checkOnesSegment("10"))  # True


if __name__ == "__main__":
    main()
