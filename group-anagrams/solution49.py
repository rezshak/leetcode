# https://leetcode.com/problems/group-anagrams/

from collections import defaultdict
from typing import List


class Solution49:

    # // T: O(nk log k), S: O(nk)
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        for s in strs:
            key = tuple(sorted(s))
            groups[key].append(s)
        return groups.values()


def main() -> None:
    sol = Solution49()
    strs1 = ["eat", "tea", "tan", "ate", "nat", "bat"]
    strs2 = [""]
    strs3 = ["a"]
    print(sol.groupAnagrams(strs1))
    print(sol.groupAnagrams(strs2))
    print(sol.groupAnagrams(strs3))


if __name__ == "__main__":
    main()
