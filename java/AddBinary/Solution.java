// https://leetcode.com/problems/add-binary/

package AddBinary;

class Solution {

    // T: O(n), S: O(n)
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ptr1 = a.length() - 1;
        int ptr2 = b.length() - 1;
        int carry = 0;
        while (ptr1 >= 0 || ptr2 >= 0) {
            if (ptr1 >= 0) {
                carry += a.charAt(ptr1--) - '0';
            }
            if (ptr2 >= 0) {
                carry += b.charAt(ptr2--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "11", s2 = "1"; // 100
        System.out.println(sol.addBinary(s1, s2));
    }

}
