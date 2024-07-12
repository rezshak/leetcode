// https://leetcode.com/problems/strobogrammatic-number/

import java.util.Map;

class Solution246 {

    private static final Map<Character, Character> STROB_MAP = Map.of(
            '0', '0',
            '1', '1',
            '6', '9',
            '8', '8',
            '9', '6');

    // T: O(n), S: O(1)
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!STROB_MAP.containsKey(leftChar) || STROB_MAP.get(leftChar) != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution246();
        System.out.println(sol.isStrobogrammatic("69")); // true
        System.out.println(sol.isStrobogrammatic("88")); // true
        System.out.println(sol.isStrobogrammatic("962")); // false
        System.out.println(sol.isStrobogrammatic("808")); // true
        System.out.println(sol.isStrobogrammatic("2")); // false
    }

}
