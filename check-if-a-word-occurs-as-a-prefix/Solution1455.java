// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

class Solution1455 {

    // T: O(nm), S: O(n)
    public int isPrefixOfWordEasy(String sentence, String searchWord) {
        var arr = sentence.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            var w = arr[i];
            if (w.startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    // T: O(n), S: O(1)
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length(), m = searchWord.length();
        int i = 0, j = 0;
        int wordIdx = 1;
        while (i < n) {
            if (sentence.charAt(i) == ' ') {
                j = 0;
                wordIdx++;
                i++;
            } else {
                if (sentence.charAt(i) == searchWord.charAt(j)) {
                    while (i < n && sentence.charAt(i) == searchWord.charAt(j)) {
                        i++;
                        j++;
                        if (j == m) {
                            return wordIdx;
                        }
                    }
                } else {
                    while (i < n && sentence.charAt(i) != ' ') {
                        i++;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution1455();
        var sent1 = "i love eating burger";
        var sent2 = "this problem is an easy problem";
        var sent3 = "i am tired";
        var sent4 = "hellohello hellohellohello";
        System.out.println(sol.isPrefixOfWordEasy(sent1, "burg")); // 4
        System.out.println(sol.isPrefixOfWord(sent1, "burg")); // 4
        System.out.println(sol.isPrefixOfWordEasy(sent2, "pro")); // 2
        System.out.println(sol.isPrefixOfWord(sent2, "pro")); // 2
        System.out.println(sol.isPrefixOfWordEasy(sent3, "you")); // -1
        System.out.println(sol.isPrefixOfWord(sent3, "you")); // -1
        System.out.println(sol.isPrefixOfWordEasy(sent4, "ell")); // -1
        System.out.println(sol.isPrefixOfWord(sent4, "ell")); // -1
    }

}
