// https://leetcode.com/problems/validate-binary-search-tree/

class Solution98 {

    // T: O(n), S: O(h)
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        // Base case: if the node is null, it is valid
        if (node == null) {
            return true;
        }

        // Check the current node's value against the bounds
        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }

        // Recursively validate the left and right subtrees
        // The left subtree must be within the range (lower, val)
        // The right subtree must be within the range (val, upper)
        return validate(node.right, node.val, upper) && validate(node.left, lower, node.val);
    }

    public static void main(String[] args) {
        var sol = new Solution98();

        var root1 = new TreeNode(2,
                new TreeNode(1), new TreeNode(3));
        System.out.println(sol.isValidBST(root1)); // true

        var root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(sol.isValidBST(root2)); // false
    }

}
