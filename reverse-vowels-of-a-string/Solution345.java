// https://leetcode.com/problems/reverse-vowels-of-a-string/

import java.util.Set;

class Solution345 {

    private static final Set<Character> VOWELS = Set.of(
            'A', 'E', 'I', 'O', 'U',
            'a', 'e', 'i', 'o', 'u');

    // T: O(n), S: O(n)
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, left = 0, right = len - 1;
        while (left < right) {
            if (!VOWELS.contains(arr[left])) {
                left++;
            } else if (!VOWELS.contains(arr[right])) {
                right--;
            } else {
                swap(arr, left++, right--);
            }
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution345();
        var s1 = "hello";
        System.out.println(sol.reverseVowels(s1)); // "holle"
        var s2 = "leetcode";
        System.out.println(sol.reverseVowels(s2)); // "leotcede"
    }

}
