// https://leetcode.com/problems/encode-and-decode-strings/

import java.util.*;

class Codec271 {

    // T: O(n), S: O(n)
    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (var str : strs) {
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    // T: O(n), S: O(n)
    public List<String> decode(String s) {
        var result = new ArrayList<String>();
        int len = s.length();
        int start = 0, end = 0;
        while (start < len) {
            while (s.charAt(end) != '#') {
                end++;
            }
            int wordLen = Integer.parseInt(s.substring(start, end));
            var word = s.substring(end + 1, end + wordLen + 1);
            result.add(word);
            start = end + wordLen + 1;
            end = start;
        }
        return result;
    }

    public static void main(String[] args) {
        Codec271 codec = new Codec271();
        List<String> strs = Arrays.asList("Hello", "World");
        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

}
