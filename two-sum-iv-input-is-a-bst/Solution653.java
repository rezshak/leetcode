// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution653 {

    // T: O(n), S: O(n)
    public boolean findTarget(TreeNode root, int k) {
        var seen = new HashSet<Integer>();
        return findTargetInorder(root, k, seen);
    }

    private boolean findTargetInorder(TreeNode root, int k, Set<Integer> seen) {
        if (root == null) {
            return false;
        }
        int diff = k - root.val;
        if (seen.contains(diff)) {
            return true;
        }
        seen.add(root.val);
        return findTargetInorder(root.left, k, seen) ||
                findTargetInorder(root.right, k, seen);
    }

    public static void main(String[] args) {
        var sol = new Solution653();
        // [5,3,6,2,4,null,7]
        var root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(sol.findTarget(root, 9)); // true
    }

}
