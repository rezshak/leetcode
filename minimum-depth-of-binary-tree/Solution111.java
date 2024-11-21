// https://leetcode.com/problems/minimum-depth-of-binary-tree/

class Solution111 {

    // T: O(n), S: O(h)
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        var sol = new Solution111();
        // Balanced tree
        var root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(sol.minDepth(root1)); // 2
        // Skewed tree
        var root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println(sol.minDepth(root2)); // 5
        // Empty tree
        TreeNode root3 = null;
        System.out.println(sol.minDepth(root3)); // 0
        // Single node tree
        var root4 = new TreeNode(1);
        System.out.println(sol.minDepth(root4)); // 1
    }

}
