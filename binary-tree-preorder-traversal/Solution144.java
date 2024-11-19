// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.*;

class Solution144 {

    // T: O(n), S: O(n)
    public List<Integer> preorderTraversal(TreeNode root) { // nlr
        var result = new ArrayList<Integer>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    // T: O(n), S: O(n)
    public List<Integer> preorderTraversalStack(TreeNode root) { // nlr
        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        var curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution144();
        // 1,null,2,3
        var root1 = new TreeNode(1);
        root1.left = null;
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(sol.preorderTraversal(root1)); // [1,2,3]
        System.out.println(sol.preorderTraversalStack(root1)); // [1,2,3]
        System.out.println(sol.preorderTraversalStack(null)); // []
    }

}
