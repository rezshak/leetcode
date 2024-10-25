# https://leetcode.com/problems/length-of-last-word/

class Solution58:

    # T: O(n), S: O(1)
    def lengthOfLastWord(self, s: str) -> int:
        r = len(s) - 1
        while r >= 0 and s[r] == ' ':
            r -= 1
        length = 0
        while r >= 0 and s[r] != ' ':
            length += 1
            r -= 1
        return length

    # T: O(n), S: O(n)
    def lengthOfLastWordBuiltin(self, s: str) -> int:
        arr = s.strip().split()
        return len(arr[-1]) if arr else 0


def main():
    sol = Solution58()
    s1 = "Hello World"
    s2 = "   fly me   to   the moon  "
    s3 = "luffy is still joyboy"
    print(sol.lengthOfLastWord(s1))        # 5
    print(sol.lengthOfLastWord(s2))        # 4
    print(sol.lengthOfLastWord(s3))        # 6
    print(sol.lengthOfLastWordBuiltin(s3))  # 6


if __name__ == "__main__":
    main()
