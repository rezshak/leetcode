// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution94 {

    // T: O(n), S: O(n)
    public List<Integer> inorderTraversal(TreeNode root) { // lnr
        var result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper(node.left, result);
            result.add(node.val);
            helper(node.right, result);
        }
    }

    // T: O(n), S: O(n)
    public List<Integer> inorderTraversalStack(TreeNode root) { // lnr
        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        var curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution94();
        // 1,null,2,3
        var root1 = new TreeNode(1);
        root1.left = null;
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(sol.inorderTraversal(root1)); // [1,3,2]
        System.out.println(sol.inorderTraversalStack(root1)); // [1,3,2]
        System.out.println(sol.inorderTraversalStack(null)); // []
    }

}
