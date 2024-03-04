// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

package KidsWithTheGreatestNumberOfCandies;

import java.util.*;

public class Solution {

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
        var sol = new Solution();
        int[] c1 = { 2, 3, 5, 1, 3 };
        int[] c2 = { 4, 2, 1, 1, 2 };
        int[] c3 = { 12, 1, 12 };
        System.out.println(sol.kidsWithCandies(c1, 3)); // [true, true, true, false, true]
        System.out.println(sol.kidsWithCandies(c2, 1)); // [true, false, false, false, false]
        System.out.println(sol.kidsWithCandies(c3, 10)); // [true, false, true]
    }
}
