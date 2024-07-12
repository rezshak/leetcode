// https://leetcode.com/problems/lexicographically-smallest-palindrome/

class Solution2697 {

    // T: O(n), S: O(n)
    public String makeSmallestPalindrome(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] > arr[right]) {
                arr[left] = arr[right];
            } else {
                arr[right] = arr[left];
            }
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        var sol = new Solution2697();
        var s1 = "egcfe";
        System.out.println(sol.makeSmallestPalindrome(s1));
    }

}
