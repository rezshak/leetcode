# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution230:

    # T: O(n), S: O(h)
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        list = []
        self.inorder(root, list)
        return list[k - 1]

    def inorder(self, node: TreeNode, list: list):
        if not node:
            return
        self.inorder(node.left, list)
        list.append(node.val)
        self.inorder(node.right, list)

    # T: O(h + k), S: O(h)
    def kthSmallestIterative(self, root: Optional[TreeNode], k: int) -> int:
        stack = []
        curr = root

        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left

            curr = stack.pop()
            k -= 1

            if k == 0:
                return curr.val

            curr = curr.right

        return -1


def main() -> None:
    sol = Solution230()

    root1 = TreeNode(3)
    root1.left = TreeNode(1)
    root1.left.right = TreeNode(2)
    root1.right = TreeNode(4)
    print(sol.kthSmallest(root1, 1))  # 1
    print(sol.kthSmallestIterative(root1, 1))  # 1

    root2 = TreeNode(5)
    root2.left = TreeNode(3)
    root2.left.left = TreeNode(2)
    root2.left.left.left = TreeNode(1)
    root2.left.right = TreeNode(4)
    root2.right = TreeNode(6)
    print(sol.kthSmallest(root2, 3))  # 3
    print(sol.kthSmallestIterative(root2, 3))  # 3


if __name__ == "__main__":
    main()
