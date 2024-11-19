# https://leetcode.com/problems/binary-tree-inorder-traversal/

from typing import List, Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution94:

    # T: O(n), S: O(n)
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.helper(root, result)
        return result

    def helper(self, node: Optional[TreeNode], result: List[int]):
        if node:
            self.helper(node.left, result)
            result.append(node.val)
            self.helper(node.right, result)

    # T: O(n), S: O(n)
    def inorderTraversalStack(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        stack = []
        curr = root

        while curr is not None or stack:
            while curr is not None:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            result.append(curr.val)
            curr = curr.right

        return result


def main() -> None:
    sol = Solution94()
    # 1,null,2,3
    root1 = TreeNode(1)
    root1.left = None
    root1.right = TreeNode(2)
    root1.right.left = TreeNode(3)
    print(sol.inorderTraversal(root1))  # [1, 3, 2]
    print(sol.inorderTraversalStack(root1))  # [1, 3, 2]
    print(sol.inorderTraversalStack(None))  # []


if __name__ == "__main__":
    main()
