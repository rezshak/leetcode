// https://leetcode.com/problems/reverse-string/

package ReverseString;

import java.util.Arrays;

class Solution {

    // T: O(n), S: O(1)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        sol.reverseString(s1);
        System.out.println(Arrays.toString(s1)); // olleh
    }

}
