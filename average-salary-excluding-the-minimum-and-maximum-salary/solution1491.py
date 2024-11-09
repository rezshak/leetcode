# https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

from typing import List


class Solution1491:

    # T: O(n), S: O(1)
    def average(self, salary: List[int]) -> None:
        min_sal, max_sal, n = salary[0], salary[0], len(salary)
        sum = 0
        for s in salary:
            min_sal = min(min_sal, s)
            max_sal = max(max_sal, s)
            sum += s
        sum -= min_sal
        sum -= max_sal
        return sum / (n - 2)


def main() -> None:
    sol = Solution1491()
    salary1 = [4000, 3000, 1000, 2000]
    salary2 = [1000, 2000, 3000]
    print(sol.average(salary1))  # 2500.0
    print(sol.average(salary2))  # 2000.0


if __name__ == "__main__":
    main()
