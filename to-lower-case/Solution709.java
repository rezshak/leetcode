// https://leetcode.com/problems/to-lower-case/

class Solution709 {

    private static final int DIFF = 'a' - 'A'; // 32
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";

    // T: O(n), S: O(1)
    public String toLowerCase(String s) {
        var sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + DIFF));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // T: O(n), S: O(n)
    public String toLowerCaseDict(String s) {
        var sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int idx = UPPER.indexOf(ch);
            sb.append(idx != -1 ? LOWER.charAt(idx) : ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution709();
        var s1 = "Hello";
        var s2 = "here";
        var s3 = "LOVELY";
        System.out.println(sol.toLowerCase(s1)); // hello
        System.out.println(sol.toLowerCaseDict(s1)); // hello
        System.out.println(sol.toLowerCase(s2)); // here
        System.out.println(sol.toLowerCaseDict(s2)); // here
        System.out.println(sol.toLowerCase(s3)); // lovely
        System.out.println(sol.toLowerCaseDict(s3)); // lovely
    }

}
