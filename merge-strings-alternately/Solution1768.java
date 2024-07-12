// https://leetcode.com/problems/merge-strings-alternately/

class Solution1768 {

    // T: O(n), S: O(n)
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int idx1 = 0, idx2 = 0;
        var sb = new StringBuilder();
        while (idx1 < len1 || idx2 < len2) {
            if (idx1 < len1) {
                sb.append(word1.charAt(idx1++));
            }
            if (idx2 < len2) {
                sb.append(word2.charAt(idx2++));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution1768();
        var w1 = "abc";
        var w2 = "pqr";
        System.out.println(sol.mergeAlternately(w1, w2));
        w1 = "ab";
        w2 = "pqrs";
        System.out.println(sol.mergeAlternately(w1, w2));
        w1 = "abcd";
        w2 = "pq";
        System.out.println(sol.mergeAlternately(w1, w2));
    }

}
