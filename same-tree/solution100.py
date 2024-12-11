# https://leetcode.com/problems/same-tree/

from collections import deque
from typing import Optional


class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution100:

    # T: O(min(n,m)), S: O(min(h1,h2))
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True

        if not p or not q:
            return False

        if p.val != q.val:
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    # T: O(min(n,m)), S: O(min(w1,w2))
    def isSameTreeBfs(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        queue1 = deque([p])
        queue2 = deque([q])

        while queue1 and queue2:
            node1 = queue1.popleft()
            node2 = queue2.popleft()

            if not node1 and not node2:
                continue

            if not node1 or not node2 or node1.val != node2.val:
                return False

            queue1.append(node1.left)
            queue2.append(node2.left)

            queue1.append(node1.right)
            queue2.append(node2.right)

        return not queue1 and not queue2


def main() -> None:
    sol = Solution100()

    p1 = TreeNode(1)
    p1.left = TreeNode(2)
    p1.right = TreeNode(3)
    q1 = TreeNode(1)
    q1.left = TreeNode(2)
    q1.right = TreeNode(3)
    print(sol.isSameTree(p1, q1))  # True
    print(sol.isSameTreeBfs(p1, q1))  # True

    p2 = TreeNode(1)
    p2.left = TreeNode(2)
    p2.right = None
    q2 = TreeNode(1)
    q2.left = None
    q2.right = TreeNode(3)
    print(sol.isSameTree(p2, q2))  # False
    print(sol.isSameTreeBfs(p2, q2))  # False


if __name__ == "__main__":
    main()
