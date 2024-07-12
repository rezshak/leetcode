// https://leetcode.com/problems/flipping-an-image/

import java.util.Arrays;

class Solution832 {

    // T: O(n), S: O(1)
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            // Only if left and right elements are the same, they change
            var row = image[i];
            int left = 0, right = n - 1;
            while (left <= right) {
                if (left == right || row[left] == row[right]) {
                    row[left] = row[right] = row[right] ^ 1;
                }
                left++;
                right--;
            }
        }
        return image;
    }

    private void printImage(int[][] image) {
        for (var row : image) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        var sol = new Solution832();
        var img1 = new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        var img2 = new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        var res1 = sol.flipAndInvertImage(img1);
        var res2 = sol.flipAndInvertImage(img2);
        sol.printImage(res1); // [[1,0,0],[0,1,0],[1,1,1]]
        sol.printImage(res2); // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    }

}
