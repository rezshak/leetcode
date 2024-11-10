# https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/

class Solution2193:

    # T: O(n), S: O(n)
    def minMovesToMakePalindrome(self, s: str) -> int:
        moves = 0
        l, r = 0, len(s) - 1
        arr = list(s)
        while l < r:
            m = r
            while m > l and arr[m] != arr[l]:
                m -= 1
            if m == l:
                arr[l], arr[l + 1] = arr[l + 1], arr[l]
                moves += 1
                continue
            while m < r:
                arr[m], arr[m + 1] = arr[m + 1], arr[m]
                m += 1
                moves += 1
            l += 1
            r -= 1

        return moves


def main() -> None:
    sol = Solution2193()
    s1 = "aabb"
    s2 = "letelt"
    print(sol.minMovesToMakePalindrome(s1))  # 2
    print(sol.minMovesToMakePalindrome(s2))  # 2


if __name__ == "__main__":
    main()
