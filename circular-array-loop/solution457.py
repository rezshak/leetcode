# https://leetcode.com/problems/circular-array-loop/

from typing import List


class Solution457:

    # T: O(n), O(1)
    def circularArrayLoop(self, nums: List[int]) -> bool:
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow, fast = i, i
            while nums[fast] * nums[i] > 0 and nums[self.next_index(nums, fast)] * nums[i] > 0:
                slow = self.next_index(nums, slow)
                fast = self.next_index(nums, self.next_index(nums, fast))
                if slow == fast:
                    if slow == self.next_index(nums, slow):
                        break
                    return True
            slow = i
            val = nums[i]
            while nums[slow] * val > 0:
                next = self.next_index(nums, slow)
                nums[slow] = 0
                slow = next
        return False

    def next_index(self, nums, i):
        n = len(nums)
        return ((i + nums[i]) % n + n) % n


def main() -> None:
    sol = Solution457()
    nums1 = [2, -1, 1, 2, 2]
    nums2 = [-1, -2, -3, -4, -5, 6]
    nums3 = [1, -1, 5, 1, 4]
    print(sol.circularArrayLoop(nums1))  # True
    print(sol.circularArrayLoop(nums2))  # False
    print(sol.circularArrayLoop(nums3))  # True


if __name__ == "__main__":
    main()
