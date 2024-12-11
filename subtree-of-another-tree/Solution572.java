// https://leetcode.com/problems/subtree-of-another-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution572 {

    // T: O(m*n), S: O(h)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Empty tree is a subtree of any tree
        if (subRoot == null) {
            return true;
        }
        // Non-empty subtree cannot be subtree of empty tree
        if (root == null) {
            return false;
        }
        // If current tree matches, return true
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // T: O(m*n), S: O(w)
    public boolean isSubtreeBfs(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // Check if current node could be start of subtree
            if (isSameTree(curr, subRoot)) {
                return true;
            }

            // Add child nodes to queue
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return false;
    }

    // T: O(min(n,m)), S: O(min(h1,h2))
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        var sol = new Solution572();
        var root1 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(5));
        var subRoot1 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println(sol.isSubtree(root1, subRoot1)); // true
        System.out.println(sol.isSubtreeBfs(root1, subRoot1)); // true

        var root2 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5));
        var subRoot2 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println(sol.isSubtree(root2, subRoot2)); // false
        System.out.println(sol.isSubtreeBfs(root2, subRoot2)); // false
    }

}
