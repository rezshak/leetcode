# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

from typing import List, Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        left_str = repr(self.left) if self.left else ""
        right_str = repr(self.right) if self.right else ""
        return f"{self.val}" + (f" ({left_str}, {right_str})" if left_str or right_str else "")


class Solution108:

    # T: O(n), S: O(n)
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:

        def helper(left, right):
            if left > right:
                return None
            mid = left + (right - left) // 2
            root = TreeNode(nums[mid])
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)
            return root

        return helper(0, len(nums) - 1)


def main() -> None:
    sol = Solution108()
    nums1 = [-10, -3, 0, 5, 9]
    nums2 = [1, 3]
    root1 = sol.sortedArrayToBST(nums1)
    root2 = sol.sortedArrayToBST(nums2)
    print(root1)
    print(root2)


if __name__ == "__main__":
    main()
