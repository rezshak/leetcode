// https://leetcode.com/problems/container-with-most-water/

class Solution11 {

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
        var sol = new Solution11();
        var height1 = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        var height2 = new int[] { 1, 1 };
        System.out.println(sol.maxArea(height1)); // 49
        System.out.println(sol.maxArea(height2)); // 1
    }

}
