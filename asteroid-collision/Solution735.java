// https://leetcode.com/problems/asteroid-collision/

import java.util.Arrays;
import java.util.Stack;

class Solution735 {

    // T: O(n), S: O(n)
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();
        for (int ast : asteroids) {
            if (ast > 0) {
                stack.push(ast);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(ast);
                } else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution735();
        var asteroids1 = new int[] { 5, 10, -5 };
        var asteroids2 = new int[] { 8, -8 };
        var asteroids3 = new int[] { 10, 2, -5 };
        System.out.println(Arrays.toString(sol.asteroidCollision(asteroids1))); // [5, 10]
        System.out.println(Arrays.toString(sol.asteroidCollision(asteroids2))); // []
        System.out.println(Arrays.toString(sol.asteroidCollision(asteroids3))); // [10]
    }

}
