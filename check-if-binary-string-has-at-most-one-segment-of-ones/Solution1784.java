// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

class Solution1784 {

    // T: O(n), S: O(1)
    public boolean checkOnesSegment(String s) {
        // If pattern 101 exists, return false
        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (curr == '0' && next == '1') {
                return false;
            }
        }
        return true;
    }

    public boolean checkOnesSegmentBuiltin(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        var sol = new Solution1784();
        System.out.println(sol.checkOnesSegment("1001")); // false
        System.out.println(sol.checkOnesSegmentBuiltin("1001")); // false
        System.out.println(sol.checkOnesSegment("110")); // true
        System.out.println(sol.checkOnesSegment("10")); // true
    }

}
