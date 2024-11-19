// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution114 {

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    // T: O(n), S: O(h)
    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
    }

    public static void main(String[] args) {
        var sol = new Solution114();
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        sol.flatten(root);
        System.out.println(root);
    }

}
