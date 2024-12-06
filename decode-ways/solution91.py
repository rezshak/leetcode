# https://leetcode.com/problems/decode-ways/

class Solution91:

    # T: O(2^n), S: O(n)
    def numDecodingsRec(self, s: str) -> int:
        return self.dfsRec(0, s)

    # T: O(2^n), S: O(n)
    def dfsRec(self, i: int, s: str) -> int:
        if i == len(s):
            return 1
        if s[i] == '0':
            return 0

        res = self.dfsRec(i + 1, s)
        if i < len(s) - 1:
            if s[i] == '1' or (s[i] == '2' and s[i + 1] < '7'):
                res += self.dfsRec(i + 2, s)
        return res

    # T: O(n), S: O(n)
    def numDecodingsDpTopDown(self, s: str) -> int:
        dp = {len(s): 1}
        return self.dfsDp(s, 0, dp)

    # T: O(n), S: O(n)
    def dfsDp(self, s: str, i: int, dp: dict) -> int:
        if i in dp:
            return dp[i]
        if s[i] == '0':
            return 0

        res = self.dfsDp(s, i + 1, dp)
        if i + 1 < len(s) and (s[i] == '1' or s[i] == '2' and s[i + 1] < '7'):
            res += self.dfsDp(s, i + 2, dp)
        dp[i] = res
        return res

    # T: O(n), S: O(n)
    def numDecodingsDpBottomUp(self, s: str) -> int:
        dp = [0] * (len(s) + 1)
        dp[len(s)] = 1
        for i in range(len(s) - 1, -1, -1):
            if s[i] == '0':
                dp[i] = 0
            else:
                dp[i] = dp[i + 1]
                if i + 1 < len(s) and (s[i] == '1' or s[i] == '2' and s[i + 1] < '7'):
                    dp[i] += dp[i + 2]
        return dp[0]

    # T: O(n), S: O(1)
    def numDecodingsDpBottomUpOpt(self, s: str) -> int:
        dp, dp2 = 0, 0
        dp1 = 1
        for i in range(len(s) - 1, -1, -1):
            if s[i] == '0':
                dp = 0
            else:
                dp = dp1
                if i + 1 < len(s) and (s[i] == '1' or s[i] == '2' and s[i + 1] < '7'):
                    dp += dp2
            dp2 = dp1
            dp1 = dp
            dp = 0
        return dp1


def main() -> None:
    sol = Solution91()
    s1 = "12"
    print(sol.numDecodingsDpTopDown(s1))  # 2
    print(sol.numDecodingsRec(s1))  # 2
    print(sol.numDecodingsDpBottomUp(s1))  # 2
    print(sol.numDecodingsDpBottomUpOpt(s1))  # 2
    s2 = "226"
    print(sol.numDecodingsDpTopDown(s2))  # 3
    print(sol.numDecodingsRec(s2))  # 3
    print(sol.numDecodingsDpBottomUp(s2))  # 3
    print(sol.numDecodingsDpBottomUpOpt(s2))  # 3
    s3 = "06"
    print(sol.numDecodingsDpTopDown(s3))  # 0
    print(sol.numDecodingsRec(s3))  # 0
    print(sol.numDecodingsDpBottomUp(s3))  # 0
    print(sol.numDecodingsDpBottomUpOpt(s3))  # 0


if __name__ == "__main__":
    main()
