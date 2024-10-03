# https://leetcode.com/problems/lucky-numbers-in-a-matrix/

from typing import List


class Solution1380:

    # T: O(m*n), S: O(m+n)
    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        n = len(matrix[0])
        rows_min = [float('inf')] * m
        cols_max = [float('-inf')] * n

        for r in range(m):
            for c in range(n):
                rows_min[r] = min(rows_min[r], matrix[r][c])

        for c in range(n):
            for r in range(m):
                cols_max[c] = max(cols_max[c], matrix[r][c])

        result = []
        for r in range(m):
            for c in range(n):
                num = matrix[r][c]
                if num == rows_min[r] and num == cols_max[c]:
                    result.append(num)

        return result


def main() -> None:
    sol = Solution1380()
    matrix = [
        [3, 7, 8],
        [9, 11, 13],
        [15, 16, 17]
    ]
    lucky_numbers_list = sol.luckyNumbers(matrix)
    print(lucky_numbers_list)  # [15]


if __name__ == "__main__":
    main()
