// https://leetcode.com/problems/container-with-most-water/

package ContainerWithMostWater;

public class Solution {

    // T: O(n), S: O(1)
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int width = end - start;
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * width);

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 }; // 49
        int[] height2 = { 1, 1 }; // 1
        System.out.println(sol.maxArea(height1));
        System.out.println(sol.maxArea(height2));
    }

}
