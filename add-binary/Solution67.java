// https://leetcode.com/problems/add-binary/

class Solution67 {

    // T: O(n), S: O(n)
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        var sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? a.charAt(i) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            int digit = sum % 2;
            sb.append(digit);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var sol = new Solution67();
        var s1 = "11";
        var s2 = "1";
        System.out.println(sol.addBinary(s1, s2)); // 100
    }

}
