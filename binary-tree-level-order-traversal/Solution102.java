// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

class Solution102 {

    // T: O(n), S: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            var currLevel = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                var currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(currLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution102();

        var root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(sol.levelOrder(root1)); // [[3],[9,20],[15,7]]

        var root2 = new TreeNode(1);
        System.out.println(sol.levelOrder(root2)); // [[1]]

        TreeNode root3 = null;
        System.out.println(sol.levelOrder(root3)); // []
    }

}
