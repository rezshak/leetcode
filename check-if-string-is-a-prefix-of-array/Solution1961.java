// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

class Solution1961 {

    // T: O(n), S: O(1)
    public boolean isPrefixString(String s, String[] words) {
        int i = 0, n = s.length();
        for (var w : words) {
            if (i == n) {
                break;
            }
            for (var ch : w.toCharArray()) {
                if (i >= n || ch != s.charAt(i)) {
                    return false;
                }
                i++;
            }
        }
        return i == n;
    }

    public static void main(String[] args) {
        var sol = new Solution1961();
        var s1 = "iloveleetcode";
        var words1 = new String[] { "i", "love", "leetcode", "apples" };
        var words2 = new String[] { "apples", "i", "love", "leetcode" };
        var words3 = new String[] { "a" };
        System.out.println(sol.isPrefixString(s1, words1)); // true
        System.out.println(sol.isPrefixString(s1, words2)); // false
        System.out.println(sol.isPrefixString(s1, words3)); // false
    }

}
