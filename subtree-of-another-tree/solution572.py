# https://leetcode.com/problems/subtree-of-another-tree/

from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution572:

    # T: O(m*n), S: O(h)
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not subRoot:
            return True
        if not root:
            return False
        if self.isSameTree(root, subRoot):
            return True
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    # T: O(m*n), S: O(w)
    def isSubtreeBfs(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not subRoot:
            return True
        if not root:
            return False

        queue = deque([root])

        while queue:
            curr = queue.popleft()

            if self.isSameTree(curr, subRoot):
                return True

            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)

        return False

    # T: O(min(n,m)), S: O(min(h1,h2))
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


def main() -> None:
    sol = Solution572()

    root1 = TreeNode(3,
                     TreeNode(4,
                              TreeNode(1),
                              TreeNode(2)),
                     TreeNode(5))
    subRoot1 = TreeNode(4,
                        TreeNode(1),
                        TreeNode(2))

    print(sol.isSubtree(root1, subRoot1))  # True
    print(sol.isSubtreeBfs(root1, subRoot1))  # True

    root2 = TreeNode(3,
                     TreeNode(4,
                              TreeNode(1),
                              TreeNode(3)),
                     TreeNode(5))
    subRoot2 = TreeNode(4,
                        TreeNode(1),
                        TreeNode(2))

    print(sol.isSubtree(root2, subRoot2))  # False
    print(sol.isSubtreeBfs(root2, subRoot2))  # False


if __name__ == "__main__":
    main()
