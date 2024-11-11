# https://leetcode.com/problems/next-permutation/

from typing import List


class Solution31:

    # T: O(n), S: O(1)
    def nextPermutation(self, nums: List[int]) -> None:
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1

        if i >= 0:
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]

        nums[i + 1:] = reversed(nums[i + 1:])


def main():
    sol = Solution31()
    nums1 = [1, 2, 3]
    nums2 = [3, 2, 1]
    nums3 = [1, 1, 5]
    sol.nextPermutation(nums1)
    sol.nextPermutation(nums2)
    sol.nextPermutation(nums3)
    print(nums1)  # Output: [1, 3, 2]
    print(nums2)  # Output: [1, 2, 3]
    print(nums3)  # Output: [1, 5, 1]


if __name__ == "__main__":
    main()
