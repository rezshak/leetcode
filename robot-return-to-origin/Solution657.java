// https://leetcode.com/problems/robot-return-to-origin/

class Solution657 {

    // T: O(n), S: O(1)
    public boolean judgeCircle(String moves) {
        var board = new int[] { 0, 0 }; // x, y
        for (char mv : moves.toCharArray()) {
            if (mv == 'U') {
                board[0]--;
            } else if (mv == 'D') {
                board[0]++;
            } else if (mv == 'R') {
                board[1]++;
            } else if (mv == 'L') {
                board[1]--;
            }
        }
        return board[0] == 0 && board[1] == 0;
    }

    public static void main(String[] args) {
        var sol = new Solution657();
        var moves1 = "UD";
        var moves2 = "LL";
        var moves3 = "UDLR";
        var moves4 = "UUDDLLRR";
        System.out.println(sol.judgeCircle(moves1)); // true
        System.out.println(sol.judgeCircle(moves2)); // false
        System.out.println(sol.judgeCircle(moves3)); // true
        System.out.println(sol.judgeCircle(moves4)); // true
    }

}
