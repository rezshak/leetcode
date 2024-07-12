// https://leetcode.com/problems/length-of-last-word/

class Solution58 {

    public int lengthOfLastWord(String s) {
        int len = s.length(), right = len - 1;
        // skip trailing spaces
        while (s.charAt(right) == ' ') {
            right--;
            continue;
        }
        int count = 0;
        while (right >= 0 && s.charAt(right) != ' ') {
            count++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new Solution58();
        var s1 = "Hello World";
        var s2 = "   fly me   to   the moon  ";
        System.out.println(sol.lengthOfLastWord(s1));
        System.out.println(sol.lengthOfLastWord(s2));
    }

}
