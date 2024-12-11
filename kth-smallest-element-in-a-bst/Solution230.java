// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution230 {

    // T: O(n), S: O(h)
    public int kthSmallest(TreeNode root, int k) {
        var list = new ArrayList<Integer>();
        inorder(root, list);
        return list.get(k - 1);
    }

    // In-order traversal of a BST returns the elements in sorted ascending order.
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // T: O(h + k), S: O(h)
    public int kthSmallestIterative(TreeNode root, int k) {
        var stack = new Stack<TreeNode>();
        var curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Push all left nodes
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop and process
            curr = stack.pop();
            k--;

            if (k == 0) {
                return curr.val;
            }

            // Move to right subtree
            curr = curr.right;
        }

        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution230();

        var root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.right = new TreeNode(4);
        System.out.println(sol.kthSmallest(root1, 1)); // 1
        System.out.println(sol.kthSmallestIterative(root1, 1)); // 1

        var root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(6);
        System.out.println(sol.kthSmallest(root2, 3)); // 3
        System.out.println(sol.kthSmallestIterative(root2, 3)); // 3
    }

}
