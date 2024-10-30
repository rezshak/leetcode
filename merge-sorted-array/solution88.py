# https://leetcode.com/problems/merge-sorted-array/

from typing import List


class Solution88:

    # T: O(n+m), S: O(1)
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        idx1 = len(nums1) - 1
        p1, p2 = m - 1, n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[idx1] = nums1[p1]
                p1 -= 1
            else:
                nums1[idx1] = nums2[p2]
                p2 -= 1
            idx1 -= 1
        while p2 >= 0:
            nums1[idx1] = nums2[p2]
            p2 -= 1
            idx1 -= 1


def main() -> None:
    sol = Solution88()
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]
    sol.merge(nums1, 3, nums2, 3)
    print(nums1)  # [1, 2, 2, 3, 5, 6]
    nums1 = [1]
    nums2 = []
    sol.merge(nums1, 1, nums2, 0)
    print(nums1)  # [1]


if __name__ == "__main__":
    main()
