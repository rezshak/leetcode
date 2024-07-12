// https://leetcode.com/problems/remove-element/

class Solution27 {

    // T: O(n), S: O(1)
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != val) {
                nums[k] = n;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        var sol = new Solution27();
        var nums1 = new int[] { 3, 2, 2, 3 };
        var nums2 = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        System.out.println(sol.removeElement(nums1, 3)); // 2
        System.out.println(sol.removeElement(nums2, 2)); // 5
    }

}
