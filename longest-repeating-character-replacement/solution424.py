# https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution424:

    # T: O(n), S: O(1)
    def characterReplacement(self, s: str, k: int) -> int:
        result = 0
        left = 0
        most_freq_count = 0
        counts = {}

        for right in range(len(s)):
            right_char = s[right]
            counts[right_char] = counts.get(right_char, 0) + 1
            most_freq_count = max(most_freq_count, counts[right_char])

            replacements_needed = right - left + 1 - most_freq_count
            if replacements_needed > k:
                left_char = s[left]
                counts[left_char] -= 1
                left += 1

            result = max(result, right - left + 1)

        return result


def main() -> None:
    sol = Solution424()
    s1 = "ABAB"
    s2 = "AABABBA"
    print(sol.characterReplacement(s1, 2))  # 4
    print(sol.characterReplacement(s2, 1))  # 4


if __name__ == "__main__":
    main()
