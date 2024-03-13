// https://leetcode.com/problems/is-subsequence/

package IsSubsequence;

class Solution {

    // T: O(n), S: O(1)
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sIdx = 0, tIdx = 0;
        while (sIdx < sLen && tIdx < tLen) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }
        return sIdx == sLen;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var s = "abc";
        var t = "ahbgdc";
        System.out.println(sol.isSubsequence(s, t)); // true
        s = "axc";
        t = "ahbgdc";
        System.out.println(sol.isSubsequence(s, t)); // false
        s = "";
        t = "ahbgdc";
        System.out.println(sol.isSubsequence(s, t)); // true
    }

}
