# https://leetcode.com/problems/valid-anagram/

from collections import Counter


class Solution242:

    # T: O(n), S: O(k)
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)


def main() -> None:
    sol = Solution242()
    s = "anagram"
    t = "nagaram"
    print(sol.isAnagram(s, t))  # true
    s = "rat"
    t = "car"
    print(sol.isAnagram(s, t))  # false


if __name__ == "__main__":
    main()
