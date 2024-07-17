// https://leetcode.com/problems/reverse-prefix-of-word/

class Solution2000 {

    // T: O(n), S: O(n)
    public String reversePrefix(String word, char ch) {
        int chIdx = word.indexOf(ch);
        if (chIdx == -1) {
            return word;
        }
        var arr = word.toCharArray();
        for (int i = 0, j = chIdx; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return new String(arr);
    }

    // T: O(n), S: O(n)
    public String reversePrefixSb(String word, char ch) {
        int chIdx = word.indexOf(ch);
        if (chIdx == -1) {
            return word;
        }
        var sb = new StringBuilder();
        for (int i = chIdx; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        for (int i = chIdx + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new Solution2000();
        var w1 = "abcdefd";
        var w2 = "xyxzxe";
        var w3 = "abcd";
        System.out.println(sol.reversePrefix(w1, 'd')); // "dcbaefd"
        System.out.println(sol.reversePrefixSb(w1, 'd')); // "dcbaefd"
        System.out.println(sol.reversePrefix(w2, 'z')); // "zxyxxe"
        System.out.println(sol.reversePrefixSb(w2, 'z')); // "zxyxxe"
        System.out.println(sol.reversePrefix(w3, 'z')); // "abcd"
        System.out.println(sol.reversePrefixSb(w3, 'z')); // "abcd"
    }

}
