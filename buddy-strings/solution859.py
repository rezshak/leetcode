# https://leetcode.com/problems/buddy-strings/

from collections import Counter


class Solution859:

    # T: O(n), S: O(1)
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        if s == goal:
            counts = Counter(s)
            return any(count >= 2 for count in counts.values())

        n, diff_count = len(s), 0
        s_counts, g_counts = [0] * 26, [0] * 26
        for i in range(n):
            s_counts[ord(s[i]) - ord('a')] += 1
            g_counts[ord(goal[i]) - ord('a')] += 1
            if s[i] != goal[i]:
                diff_count += 1
                if diff_count > 2:
                    return False

        return diff_count == 2 and s_counts == g_counts


def main() -> None:
    sol = Solution859()
    print(sol.buddyStrings("ab", "ba"))  # True
    print(sol.buddyStrings("ab", "ab"))  # False
    print(sol.buddyStrings("aa", "aa"))  # True


if __name__ == "__main__":
    main()
