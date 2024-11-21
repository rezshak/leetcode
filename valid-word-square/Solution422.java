// https://leetcode.com/problems/valid-word-square/

import java.util.*;

class Solution422 {

    // T: O(n^2), S: O(1)
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();
        for (int row = 0; row < rows; row++) {
            var word = words.get(row);
            for (int col = 0; col < word.length(); col++) {
                if (col >= rows || row >= words.get(col).length() ||
                        word.charAt(col) != words.get(col).charAt(row)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution422();
        var words1 = List.of("abcd", "bnrt", "crmy", "dtye");
        var words2 = List.of("abcd", "bnrt", "crm", "dt");
        var words3 = List.of("ball", "area", "read", "lady");
        var words4 = List.of("ball", "asee", "let", "lep");
        System.out.println(sol.validWordSquare(words1));
        System.out.println(sol.validWordSquare(words2));
        System.out.println(sol.validWordSquare(words3));
        System.out.println(sol.validWordSquare(words4));
    }

}
