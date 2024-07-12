// https://leetcode.com/problems/decode-string/

import java.util.Stack;

class Solution394 {

    // T: O(n), S: O
    public String decodeString(String s) {
        var countStack = new Stack<Integer>();
        var stringStack = new Stack<StringBuilder>();
        var currentString = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                var decodedString = stringStack.pop();
                for (int count = countStack.pop(); count > 0; count--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution394();
        var s1 = "3[a]2[bc]";
        var s2 = "3[a2[c]]";
        var s3 = "2[abc]3[cd]ef";
        System.out.println(sol.decodeString(s1)); // aaabcbc
        System.out.println(sol.decodeString(s2)); // accaccacc
        System.out.println(sol.decodeString(s3)); // abcabccdcdcdef
    }

}
