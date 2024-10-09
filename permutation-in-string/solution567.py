# https://leetcode.com/problems/permutation-in-string/

class Solution567:

    # T: O(n), S: O(1)
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1, n2 = len(s1), len(s2)
        if n1 > n2:
            return False

        counts1 = [0] * 26
        counts2 = [0] * 26

        for i in range(n1):
            counts1[ord(s1[i]) - ord('a')] += 1
            counts2[ord(s2[i]) - ord('a')] += 1

        for i in range(n1, n2):
            if counts1 == counts2:
                return True
            counts2[ord(s2[i - n1]) - ord('a')] -= 1
            counts2[ord(s2[i]) - ord('a')] += 1

        return counts1 == counts2


def main():
    sol = Solution567()
    print(sol.checkInclusion("ab", "eidbaooo"))  # True
    print(sol.checkInclusion("ab", "eidboaoo"))  # False
    print(sol.checkInclusion("adc", "dcda"))     # True


if __name__ == "__main__":
    main()
