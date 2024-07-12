// https://leetcode.com/problems/reverse-only-letters/

import java.util.Stack;

class Solution917 {

    // T: O(n), S: O(n)
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() - 1;
        var arr = s.toCharArray();
        while (left < right) {
            char leftChar = arr[left];
            char rightChar = arr[right];
            if (Character.isLetter(leftChar) && Character.isLetter(rightChar)) {
                swap(arr, left, right);
                left++;
                right--;
            } else if (!Character.isLetter(leftChar)) {
                left++;
            } else if (!Character.isLetter(rightChar)) {
                right--;
            }
        }
        return new String(arr);
    }

    // T: O(n), S: O(n)
    public String reverseOnlyStringStack(String s) {
        var st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                st.push(ch);
            }
        }
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(st.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution917();
        var s1 = "ab-cd";
        var s2 = "a-bC-dEf-ghIj";
        var s3 = "Test1ng-Leet=code-Q!";
        System.out.println(sol.reverseOnlyLetters(s1)); // "dc-ba"
        System.out.println(sol.reverseOnlyStringStack(s1)); // "dc-ba"
        System.out.println(sol.reverseOnlyLetters(s2)); // "j-Ih-gfE-dCba"
        System.out.println(sol.reverseOnlyStringStack(s2)); // "j-Ih-gfE-dCba"
        System.out.println(sol.reverseOnlyLetters(s3)); // "Qedo1ct-eeLg=ntse-T!"
        System.out.println(sol.reverseOnlyStringStack(s3)); // "Qedo1ct-eeLg=ntse-T!"
    }

}
