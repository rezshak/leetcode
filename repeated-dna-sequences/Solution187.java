// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution187 {

    private static final int K = 10;

    // T: O(n*k), S: O(n*k)
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < K) {
            return new ArrayList<>();
        }
        var counts = new HashMap<String, Integer>();
        var result = new ArrayList<String>();
        for (int i = 0; i < s.length() - K + 1; i++) { // O(n)
            var seq = s.substring(i, i + K); // O(k)
            counts.put(seq, counts.getOrDefault(seq, 0) + 1); // O(1)
            if (counts.get(seq) == 2) {
                result.add(seq); // O(1)
            }
        }
        return result;
    }

    /*
     * 1. Mapping Characters: The characters 'A', 'C', 'G', and 'T' are mapped to
     * the integers 0, 1, 2, and 3, respectively.
     *
     * 2. Rolling Hash: The idea is to maintain a rolling hash. Instead of
     * recomputing the hash of each substring from scratch, we:
     * 
     * Subtract the contribution of the leftmost character.
     * Shift the hash and add the new rightmost character.
     * 
     * 3. Base 4 Hashing: Since we have 4 unique characters, we use base 4
     * arithmetic to encode sequences. The base is raised to the power of the length
     * of the sequence minus 1 to handle character removal.
     * 
     * 4. Hash Checking: If the hash value has been seen before, we add the
     * corresponding substring to the result.
     */

    // Map characters to numbers
    private static final Map<Character, Integer> MAP = Map.of(
            'A', 0,
            'C', 1,
            'G', 2,
            'T', 3);

    // T: O(n), S: O(n)
    public List<String> findRepeatedDnaSequencesRabinKarp(String s) {
        if (s == null || s.length() < K) {
            return new ArrayList<>();
        }

        var seenHashes = new HashSet<Integer>();
        var repeatedSequences = new HashSet<String>();
        int rollingHash = 0;
        int base = 4; // We have 4 unique characters
        int hashSize = (int) Math.pow(base, K - 1); // This is base^(K-1)

        // Calculate rolling hash for the first window
        for (int i = 0; i < K; i++) {
            rollingHash = rollingHash * base + MAP.get(s.charAt(i));
        }
        seenHashes.add(rollingHash);

        // Process the rest of the windows using the rolling hash
        for (int i = 1; i < s.length() - K + 1; i++) {
            // Remove the leftmost character and add the new rightmost character
            rollingHash = rollingHash - MAP.get(s.charAt(i - 1)) * hashSize;
            rollingHash = rollingHash * base + MAP.get(s.charAt(i + K - 1));

            // Check if the hash has been seen before
            if (!seenHashes.add(rollingHash)) {
                repeatedSequences.add(s.substring(i, i + K));
            }
        }

        return new ArrayList<>(repeatedSequences);
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
