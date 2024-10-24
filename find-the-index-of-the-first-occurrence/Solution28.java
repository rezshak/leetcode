// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution28 {

    // T: O(nm), S: O(1)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int m = haystack.length(), n = needle.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }

    // T: O(n+m), S: O(1)
    public int strStrBuiltin(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // T: O(nm), S: O(n)
    public int strStrSlidingWindowSubstring(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            var substr = haystack.substring(i, i + n);
            if (substr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // T: O(n+m), S: O(1)
    public int strStrRabinKarp(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int base = 256; // A base for hashing, considering all ASCII characters.
        int prime = 101; // A prime number to mod the hash values, reducing the hash value size.
        int needleHash = 0, haystackHash = 0;
        int n = haystack.length();
        int m = needle.length();

        // Pre-compute the highest base exponent for the needle length (base^(m-1) %
        // prime).
        int highestBasePower = 1;
        for (int i = 0; i < m - 1; i++) {
            highestBasePower = (highestBasePower * base) % prime;
        }

        // Calculate the hash value of the needle and the first window of the haystack.
        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * base + needle.charAt(i)) % prime;
            haystackHash = (haystackHash * base + haystack.charAt(i)) % prime;
        }

        // Slide over the haystack string to find the first occurrence of the needle.
        for (int i = 0; i <= n - m; i++) {
            // If the current window's hash matches with the needle's hash, do a direct
            // comparison.
            if (needleHash == haystackHash) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }

            // Calculate the hash value for the next window in the haystack (if not at the
            // end).
            if (i < n - m) {
                haystackHash = (haystackHash - haystack.charAt(i) * highestBasePower) % prime;
                haystackHash = (haystackHash * base + haystack.charAt(i + m)) % prime;

                // We might get a negative hash value, convert it to positive.
                if (haystackHash < 0) {
                    haystackHash += prime;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution28();
        System.out.println(sol.strStr("sadbutsad", "sad")); // 0
        System.out.println(sol.strStr("leetcode", "leeto")); // -1
        System.out.println(sol.strStr("mississippi", "issip")); // 4
        System.out.println(sol.strStrBuiltin("mississippi", "issip")); // 4
        System.out.println(sol.strStrSlidingWindowSubstring("mississippi", "issip")); // 4
        System.out.println(sol.strStrRabinKarp("mississippi", "issip")); // 4
        System.out.println(sol.strStr("mississippi", "")); // 0
    }

}
