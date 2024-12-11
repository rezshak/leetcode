// https://leetcode.com/problems/same-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution100 {

    // T: O(min(n,m)), S: O(min(h1,h2))
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are the same
        if (p == null && q == null) {
            return true;
        }

        // If one node is null while the other isn't, trees are different
        if (p == null || q == null) {
            return false;
        }

        // Check if current node values are the same
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // T: O(min(n,m)), S: O(min(w1,w2))
    public boolean isSameTreeBfs(TreeNode p, TreeNode q) {
        // Use queues for BFS
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        // Add root nodes to respective queues
        queue1.offer(p);
        queue2.offer(q);

        // BFS traversal
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Remove nodes from both queues
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            // Check if both nodes are null
            if (node1 == null && node2 == null) {
                continue;
            }

            // If one node is null while other isn't, or values differ
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            // Add left children
            queue1.offer(node1.left);
            queue2.offer(node2.left);

            // Add right children
            queue1.offer(node1.right);
            queue2.offer(node2.right);
        }

        // Check if both queues are empty
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        var sol = new Solution100();
        var p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        var q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);
        System.out.println(sol.isSameTree(p1, q1)); // true
        System.out.println(sol.isSameTreeBfs(p1, q1)); // true

        var p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        p2.right = null;
        var q2 = new TreeNode(1);
        q2.left = null;
        q2.right = new TreeNode(3);
        System.out.println(sol.isSameTree(p2, q2)); // false
        System.out.println(sol.isSameTreeBfs(p2, q2)); // false
    }

}
