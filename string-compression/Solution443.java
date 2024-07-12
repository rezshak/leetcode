// https://leetcode.com/problems/string-compression/

import java.util.Arrays;

class Solution443 {

    // T: O(n), S: O(1)
    public int compress(char[] chars) {
        int len = chars.length;
        int resultIdx = 0, idx = 0;
        while (idx < len) {
            char currChar = chars[idx];
            int count = 0;
            while (idx < len && chars[idx] == currChar) {
                idx++;
                count++;
            }
            chars[resultIdx++] = currChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[resultIdx++] = c;
                }
            }
        }
        return resultIdx;
    }

    public static void main(String[] args) {
        var sol = new Solution443();
        var chars1 = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        var chars2 = new char[] { 'a' };
        var chars3 = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        System.out.println(sol.compress(chars1));
        System.out.println(Arrays.toString(chars1)); // ['a','2','b','2','c','3']
        System.out.println(sol.compress(chars2));
        System.out.println(Arrays.toString(chars2)); // ['a']
        System.out.println(sol.compress(chars3));
        System.out.println(Arrays.toString(chars3)); // ['a','b','1','2']
    }

}
