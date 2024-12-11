# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution235:

    # T: O(h), S: O(1)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or not p or not q:
            return None

        curr = root

        while curr:
            if p.val < curr.val and q.val < curr.val:
                curr = curr.left
            elif p.val > curr.val and q.val > curr.val:
                curr = curr.right
            else:
                return curr

        return None

    # T: O(h), S: O(h)
    def lowestCommonAncestorRec(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestorRec(root.left, p, q)

        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestorRec(root.right, p, q)

        return root


def main() -> None:
    sol = Solution235()

    root1 = TreeNode(6)
    root1.left = TreeNode(2)
    root1.right = TreeNode(8)
    root1.left.left = TreeNode(0)
    root1.left.right = TreeNode(4)
    root1.left.right.left = TreeNode(3)
    root1.left.right.right = TreeNode(5)
    root1.right.left = TreeNode(7)
    root1.right.right = TreeNode(9)

    p1 = TreeNode(2)
    q1 = TreeNode(8)
    print(sol.lowestCommonAncestor(root1, p1, q1).val)  # 6
    print(sol.lowestCommonAncestorRec(root1, p1, q1).val)  # 6

    p2 = TreeNode(2)
    q2 = TreeNode(4)
    print(sol.lowestCommonAncestor(root1, p2, q2).val)  # 2
    print(sol.lowestCommonAncestorRec(root1, p2, q2).val)  # 2


if __name__ == "__main__":
    main()
