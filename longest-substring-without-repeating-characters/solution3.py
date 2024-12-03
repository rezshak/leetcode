# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution3:

    # T: O(n), S: O(min(n, m))
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        n, max_len, l = len(s), 0, 0
        for r in range(n):
            while s[r] in seen:
                seen.remove(s[l])
                l += 1
            seen.add(s[r])
            max_len = max(max_len, r - l + 1)
        return max_len


def main() -> None:
    sol = Solution3()
    s1 = "abcabcbb"
    s2 = "bbbbb"
    s3 = "pwwkew"
    print(sol.lengthOfLongestSubstring(s1))  # 3
    print(sol.lengthOfLongestSubstring(s2))  # 1
    print(sol.lengthOfLongestSubstring(s3))  # 3


if __name__ == "__main__":
    main()
