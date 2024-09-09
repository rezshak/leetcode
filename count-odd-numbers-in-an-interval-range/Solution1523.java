// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution1523 {

    // T: O(1), S: O(1)
    public int countOdds(int low, int high) {
        if ((low & 1) == 0) {
            low++;
        }
        return low > high ? 0 : (high - low) / 2 + 1;
    }

    // T: O(h-l), S: O(1)
    public int countOddsBrute(int low, int high) {
        int count = 0;
        while (low <= high) {
            if ((low & 1) == 1) {
                count++;
            }
            low++;
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution1523();
        System.out.println(sol.countOddsBrute(3, 7)); // 3
        System.out.println(sol.countOdds(3, 7)); // 3
        System.out.println(sol.countOddsBrute(8, 10)); // 1
        System.out.println(sol.countOdds(8, 10)); // 1
    }

}
