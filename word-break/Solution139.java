// https://leetcode.com/problems/word-break/

import java.util.*;

class Solution139 {

    // Memoization map to store computed results for specific starting indices
    // Key: starting index in the string
    // Value: whether the substring from this index can be broken into dict words
    private Map<Integer, Boolean> memo;

    // T: O(n*m*t), S: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // Initialize memoization map
        // Add base case: empty string at the end of the string is always breakable
        memo = new HashMap<>();
        memo.put(s.length(), true);

        // Start depth-first search from the beginning of the string
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        // If we've already computed result for this starting index, return it
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        // Try to match words from the dictionary at the current index
        for (String w : wordDict) {
            // Check if the current word fits within the remaining string
            if (i + w.length() <= s.length() &&
            // Check if the substring matches the current word
                    s.substring(i, i + w.length()).equals(w)) {
                // Recursively check if the rest of the string can be broken
                if (dfs(s, wordDict, i + w.length())) {
                    // If a valid word break is found, memoize and return true
                    memo.put(i, true);
                    return true;
                }
            }
        }

        // If no valid word break is found from this index, memoize and return false
        memo.put(i, false);
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution139();

        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(sol.wordBreak(s1, wordDict1)); // true

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(sol.wordBreak(s2, wordDict2)); // true

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(sol.wordBreak(s3, wordDict3)); // false

        String s4 = "";
        List<String> wordDict4 = Arrays.asList("a", "b");
        System.out.println(sol.wordBreak(s4, wordDict4)); // true

        String s5 = "hello";
        List<String> wordDict5 = Arrays.asList("hello");
        System.out.println(sol.wordBreak(s5, wordDict5)); // true

        String s6 = "aaaaaaa";
        List<String> wordDict6 = Arrays.asList("aaaa", "aaa");
        System.out.println(sol.wordBreak(s6, wordDict6)); // true
    }

}
