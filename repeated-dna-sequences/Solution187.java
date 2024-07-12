// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution187 {

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

    private static final Map<Character, Integer> MAP = Map.of(
            'A', 0,
            'C', 1,
            'G', 2,
            'T', 3);

    // T: O(n), S: O(n)
    public List<String> findRepeatedDnaSequencesRabinKarp(String s) {
        int len = s.length();
        if (len < K) {
            return Collections.emptyList();
        }

        var arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = MAP.get(s.charAt(i));
        }

        int a = 4;
        int currHash = 0;

        var seen = new HashSet<Integer>();
        var result = new HashSet<String>();

        for (int i = 0; i < len - K + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < K; j++) {
                    currHash += arr[j] * (int) Math.pow(a, K - j - 1);
                }
            } else {
                int prevHash = currHash;
                currHash = ((prevHash - arr[i - 1] * (int) Math.pow(a, K - 1)) * a)
                        + arr[i + K - 1];
            }

            if (seen.contains(currHash)) {
                result.add(s.substring(i, i + K));
            }

            seen.add(currHash);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        var sol = new Solution187();
        var s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        var s2 = "AAAAAAAAAAAAA";
        System.out.println(sol.findRepeatedDnaSequences(s1));
        System.out.println(sol.findRepeatedDnaSequences(s2));
        System.out.println(sol.findRepeatedDnaSequencesRabinKarp(s1));
        System.out.println(sol.findRepeatedDnaSequencesRabinKarp(s2));
    }

}
