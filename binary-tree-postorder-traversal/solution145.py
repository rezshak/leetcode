# https://leetcode.com/problems/binary-tree-postorder-traversal/

from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution145:

    # T: O(n), S: O(n)
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def helper(node):
            if node:
                helper(node.left)
                helper(node.right)
                result.append(node.val)
        helper(root)
        return result

    # T: O(n), S: O(n)
    def postorderTraversalIterative(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        s1 = [root]
        s2 = []
        while s1:
            curr = s1.pop()
            s2.append(curr)
            if curr.left:
                s1.append(curr.left)
            if curr.right:
                s1.append(curr.right)
        while s2:
            result.append(s2.pop().val)
        return result


def main() -> None:
    sol = Solution145()
    root1 = TreeNode(1)
    root1.right = TreeNode(2)
    root1.right.left = TreeNode(3)
    print(sol.postorderTraversal(root1))         # [3, 2, 1]
    print(sol.postorderTraversalIterative(root1))  # [3, 2, 1]


if __name__ == "__main__":
    main()
