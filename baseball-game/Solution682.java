// https://leetcode.com/problems/baseball-game/

import java.util.Stack;

class Solution682 {

    // T: O(n), S: O(n)
    public int calPoints(String[] operations) {
        var stack = new Stack<Integer>();
        int ans = 0;
        for (var op : operations) {
            switch (op) {
                case "C":
                    if (!stack.isEmpty()) {
                        ans -= stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.isEmpty()) {
                        int lastScore = stack.peek();
                        int newScore = lastScore * 2;
                        stack.push(newScore);
                        ans += newScore;
                    }
                    break;
                case "+":
                    if (stack.size() >= 2) {
                        int lastScore = stack.pop();
                        int secondLastScore = stack.peek();
                        int newScore = lastScore + secondLastScore;
                        stack.push(lastScore);
                        stack.push(newScore);
                        ans += newScore;
                    }
                    break;
                default:
                    int score = Integer.parseInt(op);
                    stack.push(score);
                    ans += score;
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution682();
        var ops1 = new String[] { "5", "2", "C", "D", "+" };
        var ops2 = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
        var ops3 = new String[] { "1", "C" };
        System.out.println(sol.calPoints(ops1)); // 30
        System.out.println(sol.calPoints(ops2)); // 27
        System.out.println(sol.calPoints(ops3)); // 0
    }

}
