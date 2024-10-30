# https://leetcode.com/problems/maximum-depth-of-binary-tree/

from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution104:

    # T: O(n), S: O(n)
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        leftDepth = self.maxDepth(root.left)
        rightDepth = self.maxDepth(root.right)
        return max(leftDepth, rightDepth) + 1


def main() -> None:
    sol = Solution104()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(10)
    print(sol.maxDepth(root))  # 3


if __name__ == "__main__":
    main()
