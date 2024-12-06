# https://leetcode.com/problems/longest-palindromic-substring/

class Solution5:

    # Two pointer, expand around the center
    # T: O(n^2), S: O(1)
    def longestPalindrome(self, s: str) -> str:
        res_len, res_idx = 0, 0

        for i in range(len(s)):
            # Odd length
            l, r = i, i
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r - l + 1 > res_len:
                    res_idx = l
                    res_len = r - l + 1
                l -= 1
                r += 1
            # Even length
            l, r = i, i + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r - l + 1 > res_len:
                    res_idx = l
                    res_len = r - l + 1
                l -= 1
                r += 1

        return s[res_idx:res_idx + res_len]

    # T: O(n^2), S: O(1)
    def longestPalindromeBetterBrute(self, s: str) -> str:
        res = ""
        res_len = 0

        for i in range(len(s)):
            for j in range(i, len(s)):
                l, r = i, j
                while l < r and s[l] == s[r]:
                    l += 1
                    r -= 1

                if l >= r and res_len < (j - i + 1):
                    res = s[i:j + 1]
                    res_len = j - i + 1

        return res

    # T: O(n^2), S: O(n^2)
    def longestPalindromeDp(self, s: str) -> str:
        res_idx, res_len = 0, 0
        n = len(s)

        dp = [[False] * n for _ in range(n)]

        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j - i <= 2 or dp[i + 1][j - 1]):
                    dp[i][j] = True
                    if res_len < (j - i + 1):
                        res_idx = i
                        res_len = j - i + 1

        return s[res_idx:res_idx + res_len]

    # T: O(n^3), S: O(1)
    def longestPalindromeBrute(self, s: str) -> str:
        res = ""
        res_len = 0
        for i in range(len(s)):
            for j in range(i, len(s)):
                substr = s[i:j + 1]
                if self.isPalindrome(substr) and len(substr) > res_len:
                    res = substr
                    res_len = len(substr)
        return res

    # T: O(k), S: O(1)
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True


def main() -> None:
    sol = Solution5()
    s1 = "babad"
    s2 = "cbbd"
    s3 = "a"
    print(sol.longestPalindrome(s1))            # "bab" or "aba"
    print(sol.longestPalindromeBrute(s1))       # "bab" or "aba"
    print(sol.longestPalindromeBetterBrute(s1))  # "bab" or "aba"
    print(sol.longestPalindrome(s2))            # "bb"
    print(sol.longestPalindromeBrute(s2))       # "bb"
    print(sol.longestPalindromeBetterBrute(s2))  # "bb"
    print(sol.longestPalindrome(s3))            # "a"
    print(sol.longestPalindromeBrute(s3))       # "a"
    print(sol.longestPalindromeBetterBrute(s3))  # "a"


if __name__ == "__main__":
    main()
