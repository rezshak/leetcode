// https://leetcode.com/problems/to-lower-case/

import java.util.HashMap;
import java.util.Map;

class Solution709 {

    private static final int DIFF = 'a' - 'A'; // 32
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final Map<Character, Character> MAP = new HashMap<>();
    static {
        for (int i = 0; i < 26; ++i) {
            MAP.put(UPPER.charAt(i), LOWER.charAt(i));
        }
    }

    // T: O(n), S: O(n)
    public String toLowerCase(String s) {
        var sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + DIFF));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // T: O(n), S: O(n)
    public String toLowerCaseMap(String s) {
        var sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(MAP.containsKey(ch) ? MAP.get(ch) : ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution709();
        var s1 = "Hello";
        var s2 = "here";
        var s3 = "LOVELY";
        System.out.println(sol.toLowerCase(s1)); // hello
        System.out.println(sol.toLowerCaseMap(s1)); // hello
        System.out.println(sol.toLowerCase(s2)); // here
        System.out.println(sol.toLowerCaseMap(s2)); // here
        System.out.println(sol.toLowerCase(s3)); // lovely
        System.out.println(sol.toLowerCaseMap(s3)); // lovely
    }

}
