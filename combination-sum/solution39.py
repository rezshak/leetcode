# https://leetcode.com/problems/combination-sum/
from typing import List


class Solution39:

    # T: O(2^t), S: O(t)
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(i, cur, total):
            if total == target:
                res.append(cur.copy())
                return
            if i >= len(candidates) or total > target:
                return

            cur.append(candidates[i])
            dfs(i, cur, total + candidates[i])
            cur.pop()
            dfs(i + 1, cur, total)

        dfs(0, [], 0)
        return res


def main() -> None:
    sol = Solution39()

    candidates1 = [2, 3, 6, 7]
    target1 = 7
    result1 = sol.combinationSum(candidates1, target1)
    print(result1)  # [[2, 2, 3], [7]]

    candidates2 = [2, 3, 5]
    target2 = 8
    result2 = sol.combinationSum(candidates2, target2)
    print(result2)  # [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

    candidates3 = [2]
    target3 = 3
    result3 = sol.combinationSum(candidates3, target3)
    print(result3)  # []


if __name__ == "__main__":
    main()
