# https://leetcode.com/problems/valid-word-square/

from typing import List


class Solution422:

    # T: O(n^2), S: O(1)
    def validWordSquare(self, words: List[str]) -> bool:
        rows = len(words)
        for row in range(rows):
            word = words[row]
            for col in range(len(word)):
                if col >= rows or row >= len(words[col]) or word[col] != words[col][row]:
                    return False
        return True


def main() -> None:
    sol = Solution422()
    words1 = ["abcd", "bnrt", "crmy", "dtye"]
    words2 = ["abcd", "bnrt", "crm", "dt"]
    words3 = ["ball", "area", "read", "lady"]
    words4 = ["ball", "asee", "let", "lep"]
    print(sol.validWordSquare(words1))  # True
    print(sol.validWordSquare(words2))  # True
    print(sol.validWordSquare(words3))  # False
    print(sol.validWordSquare(words4))  # False


if __name__ == "__main__":
    main()
