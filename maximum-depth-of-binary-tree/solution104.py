# https://leetcode.com/problems/maximum-depth-of-binary-tree/

from collections import deque
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

    # T: O(n), S: O(n)
    def maxDepthBfs(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        queue = deque([root])
        level = 0

        while queue:
            size = len(queue)
            for _ in range(size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level += 1

        return level


def main() -> None:
    sol = Solution104()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(10)
    print(sol.maxDepth(root))  # 3

    root2 = TreeNode(1)
    root2.right = TreeNode(2)
    print(sol.maxDepthBfs(root2))  # 2


if __name__ == "__main__":
    main()
