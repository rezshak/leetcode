# https://leetcode.com/problems/contains-duplicate-ii/

from typing import List


class Solution219:

    # T: O(n), S: O(k)
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        num_set = set()
        for i in range(len(nums)):
            if nums[i] in num_set:
                return True
            num_set.add(nums[i])
            if len(num_set) > k:
                num_set.remove(nums[i - k])
        return False

    # T: O(n), S: O(n)
    def containsNearbyDuplicate2(self, nums: List[int], k: int) -> bool:
        num_map = {}
        for i in range(len(nums)):
            if nums[i] in num_map and i - num_map[nums[i]] <= k:
                return True
            num_map[nums[i]] = i
        return False


def main() -> None:
    sol = Solution219()
    nums1 = [1, 2, 3, 1]
    nums2 = [1, 0, 1, 1]
    nums3 = [1, 2, 3, 1, 2, 3]
    print(sol.containsNearbyDuplicate(nums1, 3))  # True
    print(sol.containsNearbyDuplicate(nums2, 1))  # True
    print(sol.containsNearbyDuplicate(nums3, 2))  # False
    print(sol.containsNearbyDuplicate2(nums1, 3))  # True
    print(sol.containsNearbyDuplicate2(nums2, 1))  # True
    print(sol.containsNearbyDuplicate2(nums3, 2))  # False


if __name__ == "__main__":
    main()
