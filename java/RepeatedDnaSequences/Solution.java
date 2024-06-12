// https://leetcode.com/problems/repeated-dna-sequences/

package RepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private static final int K = 10;

    // T: O(n), S: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        var seen = new HashMap<String, Integer>();
        var result = new ArrayList<String>();
        for (int i = 0; i < s.length() - K + 1; i++) {
            var substr = s.substring(i, i + K);
            seen.put(substr, seen.getOrDefault(substr, 0) + 1);
            if (seen.get(substr) == 2) {
                result.add(substr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        var s2 = "AAAAAAAAAAAAA";
        System.out.println(sol.findRepeatedDnaSequences(s1));
        System.out.println(sol.findRepeatedDnaSequences(s2));
    }

}
