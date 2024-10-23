# https://leetcode.com/problems/find-the-difference/

class Solution389:

    # T: O(n), S: O(1)
    def findTheDifference(self, s: str, t: str) -> str:
        s_sum = sum(ord(ch) for ch in s)
        t_sum = sum(ord(ch) for ch in t)
        return chr(t_sum - s_sum)

    # T: O(n), S: O(1)
    def findTheDifferenceDict(self, s: str, t: str) -> str:
        dict = [0] * 128
        for ch in s:
            dict[ord(ch)] += 1
        for ch in t:
            if dict[ord(ch)] == 0:
                return ch
            dict[ord(ch)] -= 1
        return '\0'

    # T: O(n), S: O(n)
    def findTheDifferenceMap(self, s: str, t: str) -> str:
        s_counts = {}
        for ch in s:
            s_counts[ch] = s_counts.get(ch, 0) + 1
        for ch in t:
            if ch not in s_counts or s_counts[ch] == 0:
                return ch
            s_counts[ch] -= 1
        return '\0'

    # T: O(n), S: O(1)
    def findTheDifferenceBitwise(self, s: str, t: str) -> str:
        res = 0
        for ch in s:
            res ^= ord(ch)
        for ch in t:
            res ^= ord(ch)
        return chr(res)


def main():
    sol = Solution389()
    s1, t1 = "abcd", "abcde"
    print(sol.findTheDifference(s1, t1))  # e
    print(sol.findTheDifferenceMap(s1, t1))  # e
    print(sol.findTheDifferenceDict(s1, t1))  # e
    print(sol.findTheDifferenceBitwise(s1, t1))  # e
    s2, t2 = "", "y"
    print(sol.findTheDifference(s2, t2))  # y
    print(sol.findTheDifferenceMap(s2, t2))  # y
    print(sol.findTheDifferenceDict(s2, t2))  # y
    print(sol.findTheDifferenceBitwise(s2, t2))  # y
    s3, t3 = "a", "aa"
    print(sol.findTheDifference(s3, t3))  # a
    print(sol.findTheDifferenceMap(s3, t3))  # a
    print(sol.findTheDifferenceDict(s3, t3))  # a
    print(sol.findTheDifferenceBitwise(s3, t3))  # a


if __name__ == "__main__":
    main()
