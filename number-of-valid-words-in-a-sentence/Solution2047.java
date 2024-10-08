// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isUpperCase;

class Solution2047 {

    // T: O(n), S: O(n)
    public int countValidWords(String sentence) {
        int count = 0;
        var words = sentence.trim().split("\\s+");
        for (var w : words) {
            if (isValid(w)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(String w) {
        int n = w.length();
        boolean hasHyphen = false;
        for (int i = 0; i < n; i++) {
            char ch = w.charAt(i);
            if (isUpperCase(ch) || isDigit(ch)) {
                return false;
            } else if (ch == '-') {
                if (hasHyphen || i == 0 || i == n - 1 || !isLetter(w.charAt(i - 1)) || !isLetter(w.charAt(i + 1))) {
                    return false;
                }
                hasHyphen = true;
            } else if (ch == '!' || ch == '.' || ch == ',') {
                if (i != n - 1) {
                    return false;
                }
            } else if (!isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution2047();
        var sent1 = "cat and  dog";
        var sent2 = "!this  1-s b8d!";
        var sent3 = "alice and  bob are playing stone-game10";
        System.out.println(sol.countValidWords(sent1)); // 3
        System.out.println(sol.countValidWords(sent2)); // 0
        System.out.println(sol.countValidWords(sent3)); // 5
    }

}
