// https://leetcode.com/problems/count-binary-substrings/

import java.util.ArrayList;

class Solution696 {

    // T: O(n), S: O(n)
    public int countBinarySubstrings(String s) {
        var list = new ArrayList<Integer>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            result += Math.min(list.get(i), list.get(i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution696();
        var s1 = "00110011";
        var s2 = "10101";
        System.out.println(sol.countBinarySubstrings(s1)); // 6
        System.out.println(sol.countBinarySubstrings(s2)); // 4
    }

}
