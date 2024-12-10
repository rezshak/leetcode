# https://leetcode.com/problems/binary-tree-level-order-traversal/


from collections import deque
from typing import List, Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution102:

    # T: O(n), S: O(n)
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root:
            return result
        queue = deque([root])
        while queue:
            level_size = len(queue)
            curr_level = []
            for _ in range(level_size):
                curr_node = queue.popleft()
                curr_level.append(curr_node.val)
                if curr_node.left:
                    queue.append(curr_node.left)
                if curr_node.right:
                    queue.append(curr_node.right)
            result.append(curr_level)
        return result


def main() -> None:
    sol = Solution102()

    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    print(sol.levelOrder(root1))  # [[3],[9,20],[15,7]]

    root2 = TreeNode(1)
    print(sol.levelOrder(root2))  # [[1]]

    root3 = None
    print(sol.levelOrder(root3))  # []


if __name__ == "__main__":
    main()
