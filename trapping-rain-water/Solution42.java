// https://leetcode.com/problems/trapping-rain-water/

class Solution42 {

    // T: O(n), S: O(1)
    public int trap(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int storedWater = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                storedWater += Math.max(0, leftMax - heights[left]);
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                storedWater += Math.max(0, rightMax - heights[right]);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }

        return storedWater;
    }

    public static void main(String[] args) {
        var sol = new Solution42();
        var height1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        var height2 = new int[] { 4, 2, 0, 3, 2, 5 };
        System.out.println(sol.trap(height1)); // 6
        System.out.println(sol.trap(height2)); // 9
    }

}
