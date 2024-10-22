# https://leetcode.com/problems/merge-strings-alternately/

class Solution1768:

    # T: O(n+m), S: O(n+m)
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n1, n2 = len(word1), len(word2)
        p1, p2 = 0, 0
        res = []
        while p1 < n1 or p2 < n2:
            if p1 < n1:
                res.append(word1[p1])
                p1 += 1
            if p2 < n2:
                res.append(word2[p2])
                p2 += 1
        return ''.join(res)


def main():
    sol = Solution1768()
    w1 = "abc"
    w2 = "pqr"
    print(sol.mergeAlternately(w1, w2))  # "apbqcr"
    w1 = "ab"
    w2 = "pqrs"
    print(sol.mergeAlternately(w1, w2))  # "apbqrs"
    w1 = "abcd"
    w2 = "pq"
    print(sol.mergeAlternately(w1, w2))  # "apbqcd"


if __name__ == "__main__":
    main()
