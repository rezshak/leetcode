// https://leetcode.com/problems/valid-word-abbreviation/

class Solution408 {

    // T: O(n), S: O(1)
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordLen = word.length(), abbrLen = abbr.length();
        int wordIdx = 0, abbrIdx = 0;
        while (wordIdx < wordLen && abbrIdx < abbrLen) {
            if (Character.isDigit(abbr.charAt(abbrIdx))) {
                if (abbr.charAt(abbrIdx) == '0') {
                    return false;
                }
                int num = 0;
                while (abbrIdx < abbrLen && Character.isDigit(abbr.charAt(abbrIdx))) {
                    num = num * 10 + (abbr.charAt(abbrIdx) - '0');
                    abbrIdx++;
                }
                wordIdx += num;
            } else {
                if (wordIdx > wordLen || word.charAt(wordIdx) != abbr.charAt(abbrIdx)) {
                    return false;
                }
                wordIdx++;
                abbrIdx++;
            }
        }
        return wordIdx == wordLen && abbrIdx == abbrLen;
    }

    public static void main(String[] args) {
        var sol = new Solution408();
        var w1 = "internationalization";
        var a1 = "i12iz4n";
        System.out.println(sol.validWordAbbreviation(w1, a1)); // true
        var w2 = "apple";
        var a2 = "a2e";
        System.out.println(sol.validWordAbbreviation(w2, a2)); // false
    }

}
