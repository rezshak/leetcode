// https://leetcode.com/problems/longest-common-prefix/

class Solution14 {

    // T: O(nm), S: O(1)
    public String longestCommonPrefix(String[] strs) {
        int endIdx = 0;
        var result = "";
        for (int i = 0; i < strs[0].length(); i++) {
            var candidate = strs[0].substring(0, endIdx + 1);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(candidate)) {
                    return result;
                }
            }
            result = candidate;
            endIdx++;
        }
        return result;
    }

    // // T: O(n), S: O(1)
    public String longestCommonPrefixOpt(String[] strs) {
        var sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (var str : strs) {
                if (i >= str.length() || str.charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution14();
        var strs1 = new String[] { "flower", "flow", "flight" };
        var strs2 = new String[] { "dog", "racecar", "car" };
        var strs3 = new String[] { "a" };
        System.out.println(sol.longestCommonPrefix(strs1)); // fl
        System.out.println(sol.longestCommonPrefix(strs2)); // ""
        System.out.println(sol.longestCommonPrefix(strs3)); // a
        System.out.println(sol.longestCommonPrefixOpt(strs1)); // fl
        System.out.println(sol.longestCommonPrefixOpt(strs2)); // ""
        System.out.println(sol.longestCommonPrefixOpt(strs3)); // a
    }

}
