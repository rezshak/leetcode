# https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

from typing import List


class Solution1491:

    # T: O(n), S: O(1)
    def average(self, salary: List[int]) -> None:
        min_s, max_s, n = salary[0], salary[0], len(salary)
        total_s = 0
        for s in salary:
            min_s = min(min_s, s)
            max_s = max(max_s, s)
            total_s += s
        total_s -= min_s
        total_s -= max_s
        avg_s = total_s / (n - 2)
        return avg_s


def main() -> None:
    sol = Solution1491()
    salary1 = [4000, 3000, 1000, 2000]
    salary2 = [1000, 2000, 3000]
    print(sol.average(salary1))  # 2500.0
    print(sol.average(salary2))  # 2000.0


if __name__ == "__main__":
    main()
