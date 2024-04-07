// https://leetcode.com/problems/simplify-path/

package SimplifyPath;

import java.util.Stack;

class Solution {

    // T: O(n), S: O(n)
    public String simplifyPath(String path) {
        var stack = new Stack<String>();
        var arr = path.split("/");
        for (String p : arr) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                stack.push(p);
            }
        }
        var result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var path1 = "/home/";
        System.out.println(sol.simplifyPath(path1)); // "/home"
        var path2 = "/../";
        System.out.println(sol.simplifyPath(path2)); // "/"
        var path3 = "/home//foo/";
        System.out.println(sol.simplifyPath(path3)); // "/home/foo"

    }

}
