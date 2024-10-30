// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution108 {

    // T: O(n), S: O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        var node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        var sol = new Solution108();
        var nums1 = new int[] { -10, -3, 0, 5, 9 };
        var nums2 = new int[] { 1, 3 };
        var root1 = sol.sortedArrayToBST(nums1);
        System.out.println(root1); // [0,-10,5,null,-3,null,9]
        var root2 = sol.sortedArrayToBST(nums2);
        System.out.println(root2); // [1,null,3]
    }

}
