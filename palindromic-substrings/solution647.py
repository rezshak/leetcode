# https://leetcode.com/problems/palindromic-substrings/

class Solution647:

    # Two pointer, expand around center
    # T: O(n^2), S: O(1)
    def countSubstrings(self, s: str) -> int:
        res = 0
        for i in range(len(s)):
            res += self.count_palindrome(s, i, i)
            res += self.count_palindrome(s, i, i + 1)
        return res

    # T: O(n), S: O(1)
    def count_palindrome(self, s: str, l: int, r: int) -> int:
        res = 0
        while l >= 0 and r < len(s) and s[l] == s[r]:
            res += 1
            l -= 1
            r += 1
        return res

    # T: O(n^2), S: O(n^2)
    def countSubstringsDp(self, s: str) -> int:
        n = len(s)
        res = 0
        dp = [[False] * n for _ in range(n)]

        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j - i <= 2 or dp[i + 1][j - 1]):
                    dp[i][j] = True
                    res += 1

        return res

    # T: O(n^3), S: O(1)
    def countSubstringsBrute(self, s: str) -> int:
        res = 0

        for i in range(len(s)):
            for j in range(i, len(s)):
                l, r = i, j
                while l < r and s[l] == s[r]:
                    l += 1
                    r -= 1
                if l >= r:
                    res += 1

        return res


def main() -> None:
    sol = Solution647()
    s1 = "abc"
    s2 = "aaa"
    print(sol.countSubstrings(s1))      # 3
    print(sol.countSubstringsBrute(s1))  # 3
    print(sol.countSubstringsDp(s1))    # 3
    print(sol.countSubstrings(s2))      # 6
    print(sol.countSubstringsDp(s2))    # 6
    print(sol.countSubstringsBrute(s2))  # 6


if __name__ == "__main__":
    main()
