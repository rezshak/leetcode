# https://leetcode.com/problems/two-sum-less-than-k/

from typing import List


class Solution1099:

    # T: O(nlogn) S: O(1)
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = -1
        left, right = 0, len(nums) - 1
        while left < right:
            sum = nums[left] + nums[right]
            if sum < k:
                ans = max(ans, sum)
                left += 1
            else:
                right -= 1
        return ans


def main() -> None:
    sol = Solution1099()
    nums1 = [34, 23, 1, 24, 75, 33, 54, 8]
    nums2 = [10, 20, 30]
    print(sol.twoSumLessThanK(nums1, 60))  # 58
    print(sol.twoSumLessThanK(nums2, 15))  # -1


if __name__ == "__main__":
    main()
