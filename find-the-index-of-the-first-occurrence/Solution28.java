// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution28 {

    // T: O(nm), S: O(1)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int hIdx = 0, nIdx = 0;
        while (hIdx < haystack.length() && nIdx < needle.length()) {
            if (haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                hIdx++;
                nIdx++;
            } else {
                hIdx -= nIdx - 1;
                nIdx = 0;
            }
            if (nIdx == needle.length()) {
                return hIdx - needle.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution28();
        System.out.println(sol.strStr("sadbutsad", "sad")); // 0
        System.out.println(sol.strStr("leetcode", "leeto")); // -1
        System.out.println(sol.strStr("mississippi", "issip")); // 4
        System.out.println(sol.strStr("mississippi", "")); // 0
    }

}
