# https://leetcode.com/problems/minimum-window-substring/

class Solution76:

    # T: O(n), S: O(k)
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        t_counts = {}
        for ch in t:
            t_counts[ch] = t_counts.get(ch, 0) + 1
        required = len(t_counts)

        min_left, min_right, min_win_len = 0, 0, float('inf')
        formed = 0
        win_counts = {}

        left = 0
        for right, right_char in enumerate(s):
            win_counts[right_char] = win_counts.get(right_char, 0) + 1

            if right_char in t_counts and win_counts[right_char] == t_counts[right_char]:
                formed += 1

            while left <= right and formed == required:
                curr_win_len = right - left + 1
                if curr_win_len < min_win_len:
                    min_win_len = curr_win_len
                    min_left = left
                    min_right = right

                left_char = s[left]
                win_counts[left_char] -= 1
                if left_char in t_counts and win_counts[left_char] < t_counts[left_char]:
                    formed -= 1
                left += 1

        return "" if min_win_len == float('inf') else s[min_left:min_right + 1]


def main() -> None:
    sol = Solution76()
    s1 = "ADOBECODEBANC"
    t1 = "ABC"
    print(sol.minWindow(s1, t1))  # "BANC"
    s2 = "a"
    t2 = "a"
    print(sol.minWindow(s2, t2))  # "a"
    s3 = "a"
    t3 = "aa"
    print(sol.minWindow(s3, t3))  # ""


if __name__ == "__main__":
    main()
