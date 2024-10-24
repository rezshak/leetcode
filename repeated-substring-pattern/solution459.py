# https://leetcode.com/problems/repeated-substring-pattern/

class Solution459:

    # T: O(n^2), S: O(n)
    def repeatedSubstringPattern(self, s: str) -> bool:
        n = len(s)
        for i in range(1, n // 2 + 1):
            if n % i == 0:
                sub = s[:i]
                sb = sub * (n // i)
                if sb == s:
                    return True
        return False

    # T: O(n), S: O(n)
    def repeatedSubstringPatternOpt(self, s: str) -> bool:
        t = s + s
        sub = t[1:-1]
        return s in sub


def main() -> None:
    sol = Solution459()
    print(sol.repeatedSubstringPattern("abab"))  # True
    print(sol.repeatedSubstringPattern("aba"))  # False
    print(sol.repeatedSubstringPattern("abcabcabcabc"))  # True
    print(sol.repeatedSubstringPatternOpt("abcabcabcabc"))  # True


if __name__ == "__main__":
    main()
