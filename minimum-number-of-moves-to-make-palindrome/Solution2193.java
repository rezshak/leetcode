// https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/

class Solution2193 {

    // T: O(n), S: O(n)
    public int minMovesToMakePalindrome(String s) {
        int moves = 0, l = 0, r = s.length() - 1;
        var arr = s.toCharArray();
        while (l < r) {
            int m = r;
            // Find the matching character for arr[l] from the end
            while (m > l && arr[m] != arr[l]) {
                m--;
            }
            // Odd length string's mid character, move to middle
            if (m == l) {
                swap(arr, l, l + 1);
                moves++;
                continue;
            }
            // Move the matching character to the correct position
            while (m < r) {
                swap(arr, m, m + 1);
                m++;
                moves++;
            }
            l++;
            r--;
        }
        return moves;
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        var sol = new Solution2193();
        var s1 = "aabb";
        var s2 = "letelt";
        System.out.println(sol.minMovesToMakePalindrome(s1)); // 2
        System.out.println(sol.minMovesToMakePalindrome(s2)); // 2
    }

}
