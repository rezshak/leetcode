// https://leetcode.com/problems/determine-if-two-strings-are-close/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution1657 {

    // T: O(n), S: O(n)
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        var counts1 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            counts1.put(ch, counts1.getOrDefault(ch, 0) + 1);
        }
        var counts2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            if (!counts1.containsKey(ch)) {
                return false;
            }
            counts2.put(ch, counts2.getOrDefault(ch, 0) + 1);
        }
        var values1 = new ArrayList<Integer>(counts1.values());
        var values2 = new ArrayList<Integer>(counts2.values());
        Collections.sort(values1);
        Collections.sort(values2);
        return values1.equals(values2);
    }

    public static void main(String[] args) {
        var sol = new Solution1657();
        var word1 = "abc";
        var word2 = "bca";
        System.out.println(sol.closeStrings(word1, word2)); // true
        word1 = "a";
        word2 = "aa";
        System.out.println(sol.closeStrings(word1, word2)); // false
        word1 = "cabbba";
        word2 = "abbccc";
        System.out.println(sol.closeStrings(word1, word2)); // true
    }

}
