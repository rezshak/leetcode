# https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution28:

    # T: O(nm), S: O(1)
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        m, n = len(haystack), len(needle)
        i, j = 0, 0
        while i < m and j < n:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == n:
                    return i - n
            else:
                i = i - j + 1
                j = 0
        return -1

    # T: O(n+m), S: O(1)
    def strStrBuiltin(self, haystack: str, needle: str) -> int:
        return haystack.find(needle)

    # T: O(nm), S: O(n)
    def strStrSlidingWindowSubstring(self, haystack: str, needle: str) -> int:
        m, n = len(haystack), len(needle)
        for i in range(m - n + 1):
            substr = haystack[i:i + n]
            if substr == needle:
                return i
        return -1

    # T: O(n+m), S: O(1)
    def strStrRabinKarp(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        if len(needle) > len(haystack):
            return -1

        base = 256  # A base for hashing, considering all ASCII characters.
        # A prime number to mod the hash values, reducing the hash value size.
        prime = 101
        needleHash = 0
        haystackHash = 0
        n = len(haystack)
        m = len(needle)

        # Pre-compute the highest base exponent for the needle length (base^(m-1) % prime).
        highestBasePower = 1
        for i in range(m - 1):
            highestBasePower = (highestBasePower * base) % prime

        # Calculate the hash value of the needle and the first window of the haystack.
        for i in range(m):
            needleHash = (needleHash * base + ord(needle[i])) % prime
            haystackHash = (haystackHash * base + ord(haystack[i])) % prime

        # Slide over the haystack string to find the first occurrence of the needle.
        for i in range(n - m + 1):
            # If the current window's hash matches with the needle's hash, do a direct comparison.
            if needleHash == haystackHash:
                if haystack[i:i + m] == needle:
                    return i

            # Calculate the hash value for the next window in the haystack (if not at the end).
            if i < n - m:
                haystackHash = (
                    haystackHash - ord(haystack[i]) * highestBasePower) % prime
                haystackHash = (haystackHash * base +
                                ord(haystack[i + m])) % prime

                # We might get a negative hash value, convert it to positive.
                if haystackHash < 0:
                    haystackHash += prime

        return -1


def main() -> None:
    sol = Solution28()
    print(sol.strStr("sadbutsad", "sad"))  # 0
    print(sol.strStr("leetcode", "leeto"))  # -1
    print(sol.strStr("mississippi", "issip"))  # 4
    print(sol.strStrBuiltin("mississippi", "issip"))  # 4
    print(sol.strStrSlidingWindowSubstring("mississippi", "issip"))  # 4
    print(sol.strStrRabinKarp("mississippi", "issip"))  # 4
    print(sol.strStr("mississippi", ""))  # 0


if __name__ == "__main__":
    main()
