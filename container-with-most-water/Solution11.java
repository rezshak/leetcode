// https://leetcode.com/problems/container-with-most-water/

class Solution11 {

    // T: O(n), S: O(1)
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int result = 0;
        while (left < right) {
            int width = right - left;
            int area = width * Math.min(heights[left], heights[right]);
            result = Math.max(result, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution11();
        var height1 = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        var height2 = new int[] { 1, 1 };
        System.out.println(sol.maxArea(height1)); // 49
        System.out.println(sol.maxArea(height2)); // 1
    }

}
