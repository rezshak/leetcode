# https://leetcode.com/problems/longest-common-prefix/

from typing import List


class Solution14:

    # T: O(n*m), S: O(1)
    def longestCommonPrefix(self, strs: List[str]) -> str:
        end_idx = 0
        result = ""
        for i in range(len(strs[0])):
            candidate = strs[0][:end_idx + 1]
            for j in range(1, len(strs)):
                if not strs[j].startswith(candidate):
                    return result
            result = candidate
            end_idx += 1
        return result

    # T: O(n*m), S: O(1)
    def longestCommonPrefixOpt(self, strs: List[str]) -> str:
        sb = []
        for i in range(len(strs[0])):
            ch = strs[0][i]
            for str in strs:
                if i >= len(str) or str[i] != ch:
                    return "".join(sb)
            sb.append(ch)
        return "".join(sb)


def main() -> None:
    sol = Solution14()
    strs1 = ["flower", "flow", "flight"]
    strs2 = ["dog", "racecar", "car"]
    strs3 = ["a"]
    print(sol.longestCommonPrefix(strs1))    # fl
    print(sol.longestCommonPrefix(strs2))    # ""
    print(sol.longestCommonPrefix(strs3))    # a
    print(sol.longestCommonPrefixOpt(strs1))  # fl
    print(sol.longestCommonPrefixOpt(strs2))  # ""
    print(sol.longestCommonPrefixOpt(strs3))  # a


if __name__ == "__main__":
    main()
