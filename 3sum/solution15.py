# https://leetcode.com/problems/3sum/

from typing import List


class Solution15:

    # T: O(n^2), S: O(n)
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = set()
        nums.sort()
        n = len(nums)
        for i in range(n - 2):
            l, r = i + 1, n - 1
            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]
                if curr_sum == 0:
                    result.add((nums[i], nums[l], nums[r]))
                    l += 1
                    r -= 1
                elif curr_sum < 0:
                    l += 1
                else:
                    r -= 1
        return [list(triplet) for triplet in result]

    # T: O(n^2), S: O(n)
    def threeSumOpt(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, n - 1
            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]
                if curr_sum == 0:
                    result.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    l += 1
                    r -= 1
                elif curr_sum < 0:
                    l += 1
                else:
                    r -= 1
        return result


def main() -> None:
    sol = Solution15()
    nums1 = [-1, 0, 1, 2, -1, -4]
    nums2 = [0, 1, 1]
    nums3 = [0, 0, 0]
    print(sol.threeSum(nums1))  # [[-1, -1, 2], [-1, 0, 1]]
    print(sol.threeSumOpt(nums1))  # [[-1, -1, 2], [-1, 0, 1]]
    print(sol.threeSum(nums2))  # []
    print(sol.threeSumOpt(nums2))  # []
    print(sol.threeSum(nums3))  # [[0, 0, 0]]
    print(sol.threeSumOpt(nums3))  # [[0, 0, 0]]


if __name__ == "__main__":
    main()
