// https://leetcode.com/problems/basic-calculator/

import java.util.Stack;

class Solution224 {

    // T: O(n), S: O(n)
    public int calculate(String exp) {
        int n = exp.length();
        var st = new Stack<Integer>();
        int num = 0, result = 0, sign = 1;
        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                num = num * 10 + digit;
            } else if (ch == '+') {
                result += num * sign;
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                result += num * sign;
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += num * sign;
                result *= st.pop();
                result += st.pop();
                num = 0;
            }
        }
        result += num * sign;
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution224();
        var s1 = "1 + 1";
        var s2 = " 2-1 + 2 ";
        var s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(sol.calculate(s1)); // 2
        System.out.println(sol.calculate(s2)); // 3
        System.out.println(sol.calculate(s3)); // 23
    }

}
