// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

import java.util.Set;

class Solution1456 {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    // T: O(n), S: O(1)
    public int maxVowels(String s, int k) {
        int maxCount = 0, currCount = 0;
        for (int i = 0; i < k; i++) {
            char currChar = s.charAt(i);
            if (VOWELS.contains(currChar)) {
                currCount++;
            }
        }
        maxCount = currCount;
        for (int i = k; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (VOWELS.contains(currChar)) {
                currCount++;
            }
            char prevChar = s.charAt(i - k);
            if (VOWELS.contains(prevChar)) {
                currCount--;
            }
            if (currCount > maxCount) {
                maxCount = currCount;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        var sol = new Solution1456();
        var s1 = "abciiidef";
        var s2 = "aeiou";
        var s3 = "leetcode";
        System.out.println(sol.maxVowels(s1, 3)); // 3
        System.out.println(sol.maxVowels(s2, 2)); // 2
        System.out.println(sol.maxVowels(s3, 3)); // 2
    }

}
