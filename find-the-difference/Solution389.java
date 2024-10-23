// https://leetcode.com/problems/find-the-difference/

import java.util.HashMap;

class Solution389 {

    // T: O(n), S: O(1)
    public char findTheDifference(String s, String t) {
        int sSum = 0, tSum = 0;
        for (char ch : s.toCharArray()) {
            sSum += (int) ch;
        }
        for (char ch : t.toCharArray()) {
            tSum += (int) ch;
        }
        return (char) (tSum - sSum);
    }

    // T: O(n), S: O(1)
    public char findTheDifferenceDict(String s, String t) {
        var dict = new int[128];
        for (char ch : s.toCharArray()) {
            dict[ch]++;
        }
        for (char ch : t.toCharArray()) {
            if (dict[ch] == 0) {
                return ch;
            }
            dict[ch]--;
        }
        return '\0';
    }

    // T: O(n), S: O(n)
    public char findTheDifferenceMap(String s, String t) {
        var sCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sCounts.put(ch, sCounts.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!sCounts.containsKey(ch) || sCounts.get(ch) == 0) {
                return ch;
            }
            int count = sCounts.get(ch);
            sCounts.put(ch, count - 1);
        }
        return '\0';
    }

    // T: O(n), S: O(1)
    public char findTheDifferenceBitwise(String s, String t) {
        char res = '\0';
        for (char ch : s.toCharArray()) {
            res ^= ch;
        }
        for (char ch : t.toCharArray()) {
            res ^= ch;
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new Solution389();
        String s1 = "abcd", t1 = "abcde";
        System.out.println(sol.findTheDifference(s1, t1)); // e
        System.out.println(sol.findTheDifferenceMap(s1, t1)); // e
        System.out.println(sol.findTheDifferenceDict(s1, t1)); // e
        System.out.println(sol.findTheDifferenceBitwise(s1, t1)); // e
        String s2 = "", t2 = "y";
        System.out.println(sol.findTheDifference(s2, t2)); // y
        System.out.println(sol.findTheDifferenceMap(s2, t2)); // y
        System.out.println(sol.findTheDifferenceDict(s2, t2)); // y
        System.out.println(sol.findTheDifferenceBitwise(s2, t2)); // y
        String s3 = "a", t3 = "aa";
        System.out.println(sol.findTheDifference(s3, t3)); // a
        System.out.println(sol.findTheDifferenceMap(s3, t3)); // a
        System.out.println(sol.findTheDifferenceDict(s3, t3)); // a
        System.out.println(sol.findTheDifferenceBitwise(s3, t3)); // a
    }

}
