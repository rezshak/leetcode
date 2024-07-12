// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution557 {

    // T: O(n), S: O(n)
    public String reverseWords(String s) {
        var arr = s.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reverseWord(arr[i]);
        }
        return String.join(" ", arr);
    }

    private String reverseWord(String w) {
        var arr = w.toCharArray();
        int left = 0, right = w.length() - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    // T: O(n), S: O(1)
    public String reverseWordsTwoPtr(String s) {
        var arr = s.toCharArray();
        int lastSpaceIndex = -1;
        int len = s.length();
        for (int strIdx = 0; strIdx < len + 1; strIdx++) {
            if (strIdx == len || arr[strIdx] == ' ') {
                int begIdx = lastSpaceIndex + 1;
                int endIdx = strIdx - 1;
                while (begIdx < endIdx) {
                    char temp = arr[begIdx];
                    arr[begIdx] = arr[endIdx];
                    arr[endIdx] = temp;
                    begIdx++;
                    endIdx--;
                }
                lastSpaceIndex = strIdx;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        var sol = new Solution557();
        var s1 = "Let's take LeetCode contest";
        System.out.println(sol.reverseWords(s1));
        System.out.println(sol.reverseWordsTwoPtr(s1));
    }

}
