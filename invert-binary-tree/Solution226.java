// https://leetcode.com/problems/invert-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution226 {

    // T: O(n), S: O(w)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS traversal
        while (!queue.isEmpty()) {
            var curr = queue.poll();

            // Swap the left and right children
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return root;
    }

    // T: O(n), S: O(h)
    public TreeNode invertTreeDfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode tempLeft = invertTreeDfs(root.left);
        TreeNode tempRight = invertTreeDfs(root.right);

        // Swap the left and right children
        root.left = tempRight;
        root.right = tempLeft;

        return root;
    }

    public static void main(String[] args) {
        var sol = new Solution226();

        var root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        System.out.println(root1);
        System.out.println(sol.invertTree(root1));

        var root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(root2);
        System.out.println(sol.invertTreeDfs(root2));
    }

}
