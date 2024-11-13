# https://leetcode.com/problems/valid-palindrome-ii/

class Solution680:

    # T: O(n), S:(1)
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return self.palindromeHelper(s, left, right - 1) or self.palindromeHelper(s, left + 1, right)
            left += 1
            right -= 1
        return True

    def palindromeHelper(self, s: str, i: int, j: int) -> bool:
        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True


def main() -> None:
    sol = Solution680()
    s1 = "aba"
    s2 = "abca"
    s3 = "abc"
    print(sol.validPalindrome(s1))  # True
    print(sol.validPalindrome(s2))  # True
    print(sol.validPalindrome(s3))  # False


if __name__ == "__main__":
    main()
