# https://leetcode.com/problems/move-zeroes/

class Solution283:

    # T: O(n), S: O(1)
    def moveZeros(self, nums):
        l, n = 0, len(nums)
        for r in range(n):
            if nums[r] != 0:
                nums[l] = nums[r]
                l += 1
        while l < n:
            nums[l] = 0
            l += 1


def main() -> None:
    sol = Solution283()
    nums1 = [0, 1, 0, 3, 12]
    nums2 = [0]
    sol.moveZeros(nums1)
    sol.moveZeros(nums2)
    print(nums1)  # [1, 3, 12, 0, 0]
    print(nums2)  # [0]


if __name__ == "__main__":
    main()
