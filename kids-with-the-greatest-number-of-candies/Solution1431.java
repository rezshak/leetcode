// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.*;

class Solution1431 {

    // T: O(n), S: O(n)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution1431();
        var c1 = new int[] { 2, 3, 5, 1, 3 };
        var c2 = new int[] { 4, 2, 1, 1, 2 };
        var c3 = new int[] { 12, 1, 12 };
        System.out.println(sol.kidsWithCandies(c1, 3)); // [true, true, true, false, true]
        System.out.println(sol.kidsWithCandies(c2, 1)); // [true, false, false, false, false]
        System.out.println(sol.kidsWithCandies(c3, 10)); // [true, false, true]
    }
}
