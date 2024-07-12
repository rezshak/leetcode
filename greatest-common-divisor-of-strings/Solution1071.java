// https://leetcode.com/problems/greatest-common-divisor-of-strings/

class Solution1071 {

    // T: O(n), S: O(n)
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    // T: O(log(min(a, b))), S: O(1)
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        var sol = new Solution1071();
        var s1 = "ABCABC";
        var s2 = "ABC";
        System.out.println(sol.gcdOfStrings(s1, s2)); // ABC
        s1 = "ABABAB";
        s2 = "ABAB";
        System.out.println(sol.gcdOfStrings(s1, s2)); // AB
        s1 = "LEET";
        s2 = "CODE";
        System.out.println(sol.gcdOfStrings(s1, s2)); // ""
    }

}
