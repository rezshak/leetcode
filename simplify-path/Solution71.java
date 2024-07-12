// https://leetcode.com/problems/simplify-path/

import java.util.Stack;

class Solution71 {

    // T: O(n), S: O(n)
    public String simplifyPath(String path) {
        var stack = new Stack<String>();
        var paths = path.split("/");
        for (var p : paths) {
            if (p.isEmpty() || p.equals(".")) {
                continue;
            }
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }
        var sb = new StringBuilder();
        for (var p : stack) {
            sb.append("/");
            sb.append(p);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution71();
        var path1 = "/home/";
        var path2 = "/../";
        var path3 = "/home//foo/";
        System.out.println(sol.simplifyPath(path1)); // "/home"
        System.out.println(sol.simplifyPath(path2)); // "/"
        System.out.println(sol.simplifyPath(path3)); // "/home/foo"
    }

}
