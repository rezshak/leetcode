// https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution145 {

    // T: O(n), S: O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper(node.left, result);
            helper(node.right, result);
            result.add(node.val);
        }
    }

    // T: O(n), S: O(n)
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        var s1 = new Stack<TreeNode>();
        var s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            var curr = s1.pop();
            s2.push(curr);

            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()) {
            result.add(s2.pop().val);
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution145();
        // [1,null,2,3]
        var root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(sol.postorderTraversal(root1)); // [3,2,1]
        System.out.println(sol.postorderTraversalIterative(root1)); // [3,2,1]
    }

}
