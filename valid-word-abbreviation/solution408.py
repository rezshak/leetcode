# https://leetcode.com/problems/valid-word-abbreviation/

class Solution408:

    # T: O(n), S: O(1)
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        word_len, abbr_len = len(word), len(abbr)
        word_idx, abbr_idx = 0, 0

        while word_idx < word_len and abbr_idx < abbr_len:
            if abbr[abbr_idx].isdigit():
                if abbr[abbr_idx] == '0':
                    return False
                num = 0
                while abbr_idx < abbr_len and abbr[abbr_idx].isdigit():
                    digit = int(abbr[abbr_idx])
                    num = num * 10 + digit
                    abbr_idx += 1
                word_idx += num
            else:
                if word_idx > word_len or word[word_idx] != abbr[abbr_idx]:
                    return False
                word_idx += 1
                abbr_idx += 1

        return word_idx == word_len and abbr_idx == abbr_len


def main():
    sol = Solution408()
    w1, a1 = "internationalization", "i12iz4n"
    print(sol.validWordAbbreviation(w1, a1))  # True
    w2, a2 = "apple", "a2e"
    print(sol.validWordAbbreviation(w2, a2))  # False
    w3, a3 = "internationalization", "i5a11o1"
    print(sol.validWordAbbreviation(w3, a3))  # True


if __name__ == "__main__":
    main()
