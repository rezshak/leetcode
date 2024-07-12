// https://leetcode.com/problems/can-place-flowers/

class Solution605 {

    // T: O(n), S: O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean rightEmpty = i == len - 1 || flowerbed[i + 1] == 0;
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
                if (count >= n) {
                    return true;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        var sol = new Solution605();
        var bed1 = new int[] { 1, 0, 0, 0, 1 };
        var bed2 = new int[] { 1, 0, 0, 0, 1 };
        System.out.println(sol.canPlaceFlowers(bed1, 1)); // true
        System.out.println(sol.canPlaceFlowers(bed2, 2)); // false
    }

}
