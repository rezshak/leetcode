// https://leetcode.com/problems/roman-to-integer/

import java.util.Map;

class Solution13 {

    private static final Map<Character, Integer> SYMS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    // T: O(n), S: O(1)
    public int romanToInt(String s) {
        int n = s.length(), ans = 0, i = 0;
        while (i < n) {
            int currVal = SYMS.get(s.charAt(i));
            int nextVal = (i < n - 1) ? SYMS.get(s.charAt(i + 1)) : 0;
            if (currVal < nextVal) {
                ans += (nextVal - currVal);
                i += 2;
            } else {
                ans += currVal;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution13();
        var s1 = "III";
        var s2 = "LVIII";
        var s3 = "MCMXCIV";
        System.out.println(sol.romanToInt(s1)); // 3
        System.out.println(sol.romanToInt(s2)); // 58
        System.out.println(sol.romanToInt(s3)); // 1994
    }

}
