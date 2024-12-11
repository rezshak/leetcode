// https://leetcode.com/problems/maximum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

class Solution104 {

    // T: O(n), S: O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(rightDepth, leftDepth) + 1;
    }

    // T: O(n), S: O(n)
    public int maxDepthBfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        var sol = new Solution104();
        var root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(10);
        System.out.println(sol.maxDepth(root1)); // 3

        var root2 = new TreeNode(1);
        root2.left = null;
        root2.right = new TreeNode(2);
        System.out.println(sol.maxDepthBfs(root2)); // 2
    }

}
