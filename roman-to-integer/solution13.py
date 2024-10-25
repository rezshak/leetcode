# https://leetcode.com/problems/roman-to-integer/

class Solution13:

    SYMS = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }

    # T: O(n), S: O(1)
    def romanToInt(self, s: str) -> int:
        n, ans, i = len(s), 0, 0
        while i < n:
            curr_val = self.SYMS[s[i]]
            next_val = self.SYMS[s[i + 1]] if i < n - 1 else 0
            if curr_val < next_val:
                ans += (next_val - curr_val)
                i += 2
            else:
                ans += (curr_val)
                i += 1
        return ans


def main() -> None:
    sol = Solution13()
    print(sol.romanToInt("III"))
    print(sol.romanToInt("LVIII"))
    print(sol.romanToInt("MCMXCIV"))


if __name__ == "__main__":
    main()
