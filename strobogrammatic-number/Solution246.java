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
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            char lch = num.charAt(l);
            char rch = num.charAt(r);
            if (!STROB_MAP.containsKey(lch) || STROB_MAP.get(lch) != rch) {
                return false;
            }
            l++;
            r--;
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
