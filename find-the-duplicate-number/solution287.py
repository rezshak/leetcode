# https://leetcode.com/problems/find-the-duplicate-number/

from typing import List


class Solution287:

    # T: O(n), S: O(n)
    def findDuplicate(self, nums: List[int]) -> int:
        seen = set()
        for n in nums:
            if n in seen:
                return n
            seen.add(n)
        return -1

    # T: O(n), S: O(1)
    def findDuplicateFloyd(self, nums: List[int]) -> int:
        slow = fast = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        slow = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow


def main() -> None:
    sol = Solution287()
    nums1 = [1, 3, 4, 2, 2]
    nums2 = [3, 1, 3, 4, 2]
    nums3 = [3, 3, 3, 3, 3]
    print(sol.findDuplicate(nums1))  # 2
    print(sol.findDuplicate(nums2))  # 3
    print(sol.findDuplicate(nums3))  # 3
    print(sol.findDuplicateFloyd(nums1))  # 2
    print(sol.findDuplicateFloyd(nums2))  # 3
    print(sol.findDuplicateFloyd(nums3))  # 3


if __name__ == "__main__":
    main()
