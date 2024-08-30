# https://leetcode.com/problems/contains-duplicate/

from typing import List


class Solution217:
    def containDuplicates(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)
