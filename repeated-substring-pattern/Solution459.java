// https://leetcode.com/problems/repeated-substring-pattern/

class Solution459 {

    // T: O(n^2), S: O(n)
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                var substring = s.substring(0, i);
                var sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    // T: O(n), S: O(n)
    public boolean repeatedSubstringPatternOpt(String s) {
        var t = s + s;
        var sub = t.substring(1, t.length() - 1);
        return sub.contains(s);
    }

    public static void main(String[] args) {
        var sol = new Solution459();
        System.out.println(sol.repeatedSubstringPattern("abab")); // true
        System.out.println(sol.repeatedSubstringPattern("aba")); // false
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc")); // true
        System.out.println(sol.repeatedSubstringPatternOpt("abcabcabcabc")); // true
    }

}
