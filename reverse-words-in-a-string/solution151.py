# https://leetcode.com/problems/reverse-words-in-a-string/


class Solution151:

    # T: O(n), S: O(n)
    def reverseWords(self, s: str) -> str:
        words = s.strip().split()
        return ' '.join(reversed(words))


def main() -> None:
    sol = Solution151()
    s1 = "a good   example"
    s2 = "world hello"
    s3 = "a good   example"
    print(sol.reverseWords(s1))  # "example good a"
    print(sol.reverseWords(s2))  # "hello world"
    print(sol.reverseWords(s3))  # "example good a"


if __name__ == "__main__":
    main()
