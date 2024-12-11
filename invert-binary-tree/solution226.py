# https://leetcode.com/problems/invert-binary-tree/

from collections import deque
from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution226:

    # T: O(n), S: O(w)
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None

        queue = deque([root])

        while queue:
            curr = queue.popleft()

            # Swap the left and right children
            curr.left, curr.right = curr.right, curr.left

            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)

        return root

    # T: O(n), S: O(h)
    def invertTreeDfs(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None

        # Recursively invert the left and right subtrees
        temp_left = self.invertTreeDfs(root.left)
        temp_right = self.invertTreeDfs(root.right)

        # Swap the left and right children
        root.left = temp_right
        root.right = temp_left

        return root


def printTreeInorder(root):
    if not root:
        return
    printTreeInorder(root.left)
    print(root.val, end=' ')
    printTreeInorder(root.right)


def main() -> None:
    sol = Solution226()

    root1 = TreeNode(4)
    root1.left = TreeNode(2)
    root1.right = TreeNode(7)
    root1.left.left = TreeNode(1)
    root1.left.right = TreeNode(3)
    root1.right.left = TreeNode(6)
    root1.right.right = TreeNode(9)
    print("Original Tree (Inorder):", end=' ')
    printTreeInorder(root1)
    print("\nInverted Tree (Inorder):", end=' ')
    sol.invertTree(root1)
    printTreeInorder(root1)
    print()

    root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)
    print("Original Tree (Inorder):", end=' ')
    printTreeInorder(root2)
    print("\nInverted Tree (Inorder):", end=' ')
    sol.invertTreeDfs(root2)
    printTreeInorder(root2)


if __name__ == "__main__":
    main()
