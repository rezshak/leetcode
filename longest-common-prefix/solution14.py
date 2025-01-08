# https://leetcode.com/problems/longest-common-prefix/

from typing import List


class Solution14:

    # T: O(S) where S is sum of all characters, S: O(1)
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        min_len = min(len(s) for s in strs)
        result = []

        for i in range(min_len):
            ch = strs[0][i]
            if not all(s[i] == ch for s in strs):
                break
            result.append(ch)

        return "".join(result)

    # T: O(S) where S is sum of all characters, S: O(1)
    def longestCommonPrefixOpt1(self, strs: List[str]) -> str:
        if not strs:
            return ""

        result = []
        for i in range(len(strs[0])):
            ch = strs[0][i]
            if any(i >= len(s) or s[i] != ch for s in strs):
                break
            result.append(ch)

        return "".join(result)

    # T: O(n*log(n)) for sorting + O(m) for comparison
    # S: O(1) not counting the sort space
    def longestCommonPrefixOpt2(self, strs: List[str]) -> str:
        if not strs:
            return ""

        strs.sort()
        first, last = strs[0], strs[-1]

        for i, ch in enumerate(first):
            if i >= len(last) or ch != last[i]:
                return first[:i]

        return first


def main() -> None:
    sol = Solution14()
    strs1 = ["flower", "flow", "flight"]
    strs2 = ["dog", "racecar", "car"]
    strs3 = ["a"]
    print(sol.longestCommonPrefix(strs1))    # fl
    print(sol.longestCommonPrefix(strs2))    # ""
    print(sol.longestCommonPrefix(strs3))    # a
    print(sol.longestCommonPrefixOpt1(strs1))  # fl
    print(sol.longestCommonPrefixOpt1(strs2))  # ""
    print(sol.longestCommonPrefixOpt1(strs3))  # a
    print(sol.longestCommonPrefixOpt2(strs1))  # fl
    print(sol.longestCommonPrefixOpt2(strs2))  # ""
    print(sol.longestCommonPrefixOpt2(strs3))  # a


if __name__ == "__main__":
    main()
