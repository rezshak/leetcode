# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution3:

    # T: O(n), S: O(k) where k is the unique characters in the string
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        left, right = 0, 0
        result = 0
        while right < len(s):
            if s[right] in seen:
                seen.remove(s[left])
                left += 1
            else:
                seen.add(s[right])
                right += 1
                result = max(result, right - left)

        return result

    # T: O(n), S: O(k
    def lengthOfLongestSubstringOpt(self, s: str) -> int:
        indices = dict()
        result = 0
        left = 0
        for right in range(len(s)):
            if s[right] in indices and indices[s[right]] >= left:
                left = indices[s[right]] + 1

            indices[s[right]] = right

            result = max(result, right - left + 1)

        return result


def main() -> None:
    sol = Solution3()
    s1 = "abcabcbb"
    s2 = "bbbbb"
    s3 = "pwwkew"
    s4 = "aab"
    print(sol.lengthOfLongestSubstring(s1))  # 3
    print(sol.lengthOfLongestSubstringOpt(s1))  # 3
    print(sol.lengthOfLongestSubstring(s2))  # 1
    print(sol.lengthOfLongestSubstringOpt(s2))  # 1
    print(sol.lengthOfLongestSubstring(s3))  # 3
    print(sol.lengthOfLongestSubstringOpt(s3))  # 3
    print(sol.lengthOfLongestSubstring(s4))  # 2
    print(sol.lengthOfLongestSubstringOpt(s4))  # 2


if __name__ == "__main__":
    main()
