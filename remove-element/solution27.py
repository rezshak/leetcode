# https://leetcode.com/problems/remove-element/

from typing import List


class Solution27:

    # T: O(n), S: O(1)
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
            else:
                nums[i] = 0

        return k


def main() -> None:
    sol = Solution27()
    nums1 = [3, 2, 2, 3]
    nums2 = [0, 1, 2, 2, 3, 0, 4, 2]
    print(sol.removeElements(nums1, 3))  # 2
    print(sol.removeElements(nums2, 2))  # 5


if __name__ == "__main__":
    main()
