// https://leetcode.com/problems/reverse-string-ii/

class Solution541 {

    // T: O(n), S: O(n)
    public String reverseStr(String s, int k) {
        var arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int beg = i, end = Math.min(beg + k - 1, arr.length - 1);
            while (beg < end) {
                char temp = arr[beg];
                arr[beg] = arr[end];
                arr[end] = temp;
                beg++;
                end--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        var sol = new Solution541();
        var s1 = "abcdefg";
        var s2 = "abcd";
        System.out.println(sol.reverseStr(s1, 2)); // "bacdfeg"
        System.out.println(sol.reverseStr(s2, 2)); // "bacd"
    }

}
