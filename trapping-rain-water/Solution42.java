// https://leetcode.com/problems/trapping-rain-water/

class Solution42 {

    // T: O(n), S: O(1)
    public int trap(int[] height) {
        // Edge case: if array is empty or too small to trap water
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Update maximum heights seen so far
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // If left wall is smaller, calculate water trapped at left position
            if (leftMax < rightMax) {
                totalWater += leftMax - height[left];
                left++;
            }
            // If right wall is smaller, calculate water trapped at right position
            else {
                totalWater += rightMax - height[right];
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        var sol = new Solution42();
        var height1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        var height2 = new int[] { 4, 2, 0, 3, 2, 5 };
        System.out.println(sol.trap(height1)); // 6
        System.out.println(sol.trap(height2)); // 9
    }

}
