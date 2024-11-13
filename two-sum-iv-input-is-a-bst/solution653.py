# https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution653:

    # T: O(n), S: O(n)
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        seen = set()
        return self.findTargetInorder(root, k, seen)

    def findTargetInorder(self, root: TreeNode, k: int, seen: set) -> bool:
        if root is None:
            return False
        diff = k - root.val
        if diff in seen:
            return True
        seen.add(root.val)
        return self.findTargetInorder(root.left, k, seen) or self.findTargetInorder(root.right, k, seen)


def main() -> None:
    sol = Solution653()
    # [5,3,6,2,4,null,7]
    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(7)
    print(sol.findTarget(root, 9))  # True


if __name__ == "__main__":
    main()
