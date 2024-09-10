# https://leetcode.com/problems/valid-palindrome/

class Solution125:

    # T: O(n), S: O(1)
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while left < right and not s[right].isalnum():
                right -= 1
            if s[left].lower() != s[right].lower():
                return False
            left += 1
            right -= 1

        return True


def main() -> None:
    sol = Solution125()
    s1 = "A man, a plan, a canal: Panama"
    s2 = "race a car"
    s3 = " "
    print(sol.isPalindrome(s1))  # False
    print(sol.isPalindrome(s2))  # Fales
    print(sol.isPalindrome(s3))  # True


if __name__ == "__main__":
    main()
