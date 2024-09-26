# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution3:

    # T: O(n), S: O(min(n, m))
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r, n = 0, 0, len(s)
        res = 0
        seen = set()
        while r < n:
            if s[r] not in seen:
                seen.add(s[r])
                r += 1
            else:
                seen.remove(s[l])
                l += 1

            res = max(res, len(seen))

        return res


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
