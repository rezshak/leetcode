// https://leetcode.com/problems/maximum-depth-of-binary-tree/

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

    public static void main(String[] args) {
        var sol = new Solution104();
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(10);
        System.out.println(sol.maxDepth(root)); // 3
    }

}
