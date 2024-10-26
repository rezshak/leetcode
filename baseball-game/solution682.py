# https://leetcode.com/problems/baseball-game/

from typing import List


class Solution682:

    #  T: O(n), S: O(n)
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        ans = 0
        for op in operations:
            if op == "C":
                if stack:
                    ans -= stack.pop()
            elif op == "D":
                if stack:
                    last_score = stack[-1]
                    new_score = last_score * 2
                    stack.append(new_score)
                    ans += new_score
            elif op == "+":
                if len(stack) >= 2:
                    last_score = stack.pop()
                    second_last_score = stack[-1]
                    new_score = last_score + second_last_score
                    stack.append(last_score)
                    stack.append(new_score)
                    ans += new_score
            else:
                score = int(op)
                stack.append(score)
                ans += score
        return ans


def main() -> None:
    sol = Solution682()
    ops1 = ["5", "2", "C", "D", "+"]
    ops2 = ["5", "-2", "4", "C", "D", "9", "+", "+"]
    ops3 = ["1", "C"]
    print(sol.calPoints(ops1))  # 30
    print(sol.calPoints(ops2))  # 27
    print(sol.calPoints(ops3))  # 0


if __name__ == "__main__":
    main()
