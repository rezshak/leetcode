# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

from typing import List


class Solution17:

    DIGIT_TO_LETTERS = [
        "",    # 0
        "",    # 1
        "abc",  # 2
        "def",  # 3
        "ghi",  # 4
        "jkl",  # 5
        "mno",  # 6
        "pqrs",  # 7
        "tuv",  # 8
        "wxyz"  # 9
    ]

    def letterCombinations(self, digits: str) -> List[str]:
        result = []

        if not digits:
            return result

        self.backtrack(digits, 0, [], result)

        return result

    def backtrack(self, digits, index, current, result):
        if index == len(digits):
            result.append("".join(current))
            return

        digit = int(digits[index])
        letters = self.DIGIT_TO_LETTERS[digit]

        for letter in letters:
            current.append(letter)
            self.backtrack(digits, index + 1, current, result)
            current.pop()


def main() -> None:
    sol = Solution17()
    digits1 = "23"
    digits2 = ""
    digits3 = "2"
    # ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    print(sol.letterCombinations(digits1))
    print(sol.letterCombinations(digits2))  # []
    print(sol.letterCombinations(digits3))  # ["a","b","c"]


if __name__ == "__main__":
    main()
