# https://leetcode.com/problems/minimum-depth-of-binary-tree/

from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution111:

    # T: O(n), S: O(h)
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        if root.left is None:
            return self.minDepth(root.right) + 1
        if root.right is None:
            return self.minDepth(root.left) + 1
        left_depth = self.minDepth(root.left)
        right_depth = self.minDepth(root.right)
        return min(left_depth, right_depth) + 1


def main() -> None:
    sol = Solution111()
    # Balanced tree
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    print(sol.minDepth(root1))  # 2
    # Skewed tree
    root2 = TreeNode(2)
    root2.right = TreeNode(3)
    root2.right.right = TreeNode(4)
    root2.right.right.right = TreeNode(5)
    root2.right.right.right.right = TreeNode(6)
    print(sol.minDepth(root2))  # 5
    # Empty tree
    root3 = None
    print(sol.minDepth(root3))  # 0
    # Single node tree
    root4 = TreeNode(1)
    print(sol.minDepth(root4))  # 1


if __name__ == "__main__":
    main()
