// https://leetcode.com/problems/merge-strings-alternately/

class Solution1768 {

    // T: O(n+m), S: O(n+m)
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int p1 = 0, p2 = 0;
        var sb = new StringBuilder();
        while (p1 < n1 || p2 < n2) {
            if (p1 < n1) {
                sb.append(word1.charAt(p1++));
            }
            if (p2 < n2) {
                sb.append(word2.charAt(p2++));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution1768();
        var w1 = "abc";
        var w2 = "pqr";
        System.out.println(sol.mergeAlternately(w1, w2)); // "apbqcr"
        w1 = "ab";
        w2 = "pqrs";
        System.out.println(sol.mergeAlternately(w1, w2)); // "apbqrs"
        w1 = "abcd";
        w2 = "pq";
        System.out.println(sol.mergeAlternately(w1, w2)); // "apbqcd"
    }

}
