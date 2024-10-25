// https://leetcode.com/problems/length-of-last-word/

class Solution58 {

    // T: O(n), S: O(1)
    public int lengthOfLastWord(String s) {
        int r = s.length() - 1;
        while (r >= 0 && s.charAt(r) == ' ') {
            r--;
        }
        int len = 0;
        while (r >= 0 && s.charAt(r) != ' ') {
            len++;
            r--;
        }
        return len;
    }

    // T: O(n), S: O(n)
    public int lengthOfLastWordBuiltin(String s) {
        var arr = s.trim().split("\\s+");
        int n = arr.length;
        return arr[n - 1].length();
    }

    public static void main(String[] args) {
        var sol = new Solution58();
        var s1 = "Hello World";
        var s2 = "   fly me   to   the moon  ";
        var s3 = "luffy is still joyboy";
        System.out.println(sol.lengthOfLastWord(s1)); // 5
        System.out.println(sol.lengthOfLastWord(s2)); // 4
        System.out.println(sol.lengthOfLastWord(s3)); // 6
        System.out.println(sol.lengthOfLastWordBuiltin(s3)); // 6
    }

}
