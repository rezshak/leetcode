# https://leetcode.com/problems/validate-binary-search-tree/

from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution98:

    # T: O(n), S: O(h)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root, None, None)

    def validate(self, node: TreeNode, lower: int, upper: int) -> bool:
        if not node:
            return True

        if lower is not None and node.val <= lower:
            return False
        if upper is not None and node.val >= upper:
            return False

        return self.validate(node.right, node.val, upper) and self.validate(node.left, lower, node.val)


def main() -> None:
    sol = Solution98()

    root1 = TreeNode(2, TreeNode(1), TreeNode(3))
    print(sol.isValidBST(root1))  # True

    root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(4)
    root2.right.left = TreeNode(3)
    root2.right.right = TreeNode(6)
    print(sol.isValidBST(root2))  # False


if __name__ == "__main__":
    main()
