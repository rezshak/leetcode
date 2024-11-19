# https://leetcode.com/problems/binary-tree-preorder-traversal/

from typing import List, Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution144:

    # T: O(n), S: O(n)
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:  # nlr
        result = []
        self.preorderHelper(root, result)
        return result

    def preorderHelper(self, node: Optional[TreeNode], result: List[int]):
        if node is None:
            return
        result.append(node.val)
        self.preorderHelper(node.left, result)
        self.preorderHelper(node.right, result)

    # T: O(n), S: O(n)
    def preorderTraversalStack(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        stack = []
        curr = root

        while curr is not None or stack:
            while curr is not None:
                result.append(curr.val)
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            curr = curr.right

        return result


def main() -> None:
    sol = Solution144()
    # 1,null,2,3
    root1 = TreeNode(1)
    root1.left = None
    root1.right = TreeNode(2)
    root1.right.left = TreeNode(3)
    print(sol.preorderTraversal(root1))  # [1, 2, 3]
    print(sol.preorderTraversalStack(root1))  # [1, 2, 3]
    print(sol.preorderTraversalStack(None))  # []


if __name__ == "__main__":
    main()
