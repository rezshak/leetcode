// https://leetcode.com/problems/reverse-words-in-a-string/

class Solution151 {

    // T: O(n), S: O(n)
    public String reverseWords(String s) {
        var arr = s.trim().split("\\s+");
        int left = 0, right = arr.length - 1;
        while (left < right) {
            var temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        var sol = new Solution151();
        var s1 = "a good   example";
        var s2 = "world hello";
        var s3 = "a good   example";
        System.out.println(sol.reverseWords(s1)); // "example good a"
        System.out.println(sol.reverseWords(s2)); // "world hello"
        System.out.println(sol.reverseWords(s3)); // "example good a"
    }

}
