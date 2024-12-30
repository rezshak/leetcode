// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

class Solution17 {

    // Map to store digit to letters mapping
    private final String[] DIGIT_TO_LETTERS = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    // T: O(n4^n), S: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Handle empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Start backtracking with empty combination
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if we've processed all digits, add the combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the current digit and its corresponding letters
        int digit = digits.charAt(index) - '0';
        String letters = DIGIT_TO_LETTERS[digit];

        // Try each letter for the current digit
        for (char letter : letters.toCharArray()) {
            // Add current letter
            current.append(letter);

            // Recurse for next digit
            backtrack(digits, index + 1, current, result);

            // Remove current letter (backtrack)
            current.setLength(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        var sol = new Solution17();
        var digts1 = "23";
        var digts2 = "";
        var digts3 = "2";
        System.out.println(sol.letterCombinations(digts1)); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(sol.letterCombinations(digts2)); // []
        System.out.println(sol.letterCombinations(digts3)); // ["a","b","c"]
    }

}
