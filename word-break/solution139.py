# https://leetcode.com/problems/word-break/description/

from typing import List


class Solution139:

    def __init__(self):
        self.memo = {}

    # T: O(n*m*t), S: O(n)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo = {len(s): True}
        return self.dfs(s, wordDict, 0)

    def dfs(self, s, wordDict, i):
        if i in self.memo:
            return self.memo[i]

        for w in wordDict:
            if i + len(w) <= len(s) and s[i:i+len(w)] == w:
                if self.dfs(s, wordDict, i + len(w)):
                    self.memo[i] = True
                    return True

        self.memo[i] = False
        return False


def main() -> None:
    sol = Solution139()

    s1 = "leetcode"
    wordDict1 = ["leet", "code"]
    print(sol.wordBreak(s1, wordDict1))  # true

    s2 = "applepenapple"
    wordDict2 = ["apple", "pen"]
    print(sol.wordBreak(s2, wordDict2))  # true

    s3 = "catsandog"
    wordDict3 = ["cats", "dog", "sand", "and", "cat"]
    print(sol.wordBreak(s3, wordDict3))  # false

    s4 = ""
    wordDict4 = ["a", "b"]
    print(sol.wordBreak(s4, wordDict4))  # true

    s5 = "hello"
    wordDict5 = ["hello"]
    print(sol.wordBreak(s5, wordDict5))  # true

    s6 = "aaaaaaa"
    wordDict6 = ["aaaa", "aaa"]
    print(sol.wordBreak(s6, wordDict6))  # true


if __name__ == "__main__":
    main()
