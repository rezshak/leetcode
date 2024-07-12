// https://leetcode.com/problems/long-pressed-name/

class Solution925 {

    // T: O(n), S: O(1)
    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        var sol = new Solution925();
        var n1 = "alex";
        var t1 = "aaleex";
        var n2 = "saeed";
        var t2 = "ssaaedd";
        System.out.println(sol.isLongPressedName(n1, t1)); // true
        System.out.println(sol.isLongPressedName(n2, t2)); // false
    }

}
