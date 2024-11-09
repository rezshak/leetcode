# https://leetcode.com/problems/sort-colors/

from typing import List


class Solution75:

    # T: O(n), S: O(1)
    def sortColors(self, nums: List[int]) -> None:
        cnt0, cnt1, cnt2 = 0, 0, 0
        for n in nums:
            if n == 0:
                cnt0 += 1
            elif n == 1:
                cnt1 += 1
            elif n == 2:
                cnt2 += 1
        i = 0
        while cnt0 > 0:
            nums[i] = 0
            i += 1
            cnt0 -= 1
        while cnt1 > 0:
            nums[i] = 1
            i += 1
            cnt1 -= 1
        while cnt2 > 0:
            nums[i] = 2
            i += 1
            cnt2 -= 1

    # T: O(n), S: O(1)
    def sortColorsOnePass(self, nums: List[int]) -> None:
        p0, p1, p2 = 0, 0, len(nums) - 1
        while p1 <= p2:
            if nums[p1] == 0:
                nums[p0], nums[p1] = nums[p1], nums[p0]
                p0 += 1
                p1 += 1
            elif nums[p1] == 1:
                p1 += 1
            else:
                nums[p2], nums[p1] = nums[p1], nums[p2]
                p2 -= 1


def main():
    sol = Solution75()
    nums1 = [2, 0, 2, 1, 1, 0]
    nums2 = [2, 0, 1]
    nums3 = [0, 2, 1]
    sol.sortColorsOnePass(nums1)
    sol.sortColorsOnePass(nums2)
    sol.sortColors(nums3)
    print(nums1)  # [0,0,1,1,2,2]
    print(nums2)  # [0,1,2]
    print(nums3)  # [0,1,2]


if __name__ == "__main__":
    main()
