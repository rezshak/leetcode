// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

class Solution235 {

    // T: O(h), S: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        var curr = root;

        while (curr != null) {
            // If both p and q are smaller than current node, move to left subtree
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // If both p and q are larger than current node, move to right subtree
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // If p and q are on different sides or one of them is the current node,
            // current node is the LCA
            else {
                return curr;
            }
        }

        // Shouldn't be reached if p and q are guaranteed to exist in the tree
        return null;
    }

    // T: O(h), S: O(h)
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are smaller than current node,
        // LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are larger than current node,
        // LCA must be in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If p and q are on different sides or one of them is the current node,
        // current node is the LCA
        return root;
    }

    public static void main(String[] args) {
        var sol = new Solution235();

        var root1 = new TreeNode(6);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        var p1 = new TreeNode(2);
        var q1 = new TreeNode(8);
        System.out.println(sol.lowestCommonAncestor(root1, p1, q1)); // 6
        System.out.println(sol.lowestCommonAncestorRec(root1, p1, q1)); // 6

        var p2 = new TreeNode(2);
        var q2 = new TreeNode(4);
        System.out.println(sol.lowestCommonAncestor(root1, p2, q2)); // 2
        System.out.println(sol.lowestCommonAncestorRec(root1, p2, q2)); // 2
    }

}
