# https://leetcode.com/problems/matrix-diagonal-sum/

from typing import List


class Solution1572:

    # T: O(n), S: O(1)
    def diagonalSum(self, mat: List[List[int]]) -> int:
        n = len(mat)
        diagSum, antiDiagSum = 0, 0
        for i in range(n):
            diagSum += mat[i][i]
            if i != n - 1 - i:
                antiDiagSum += mat[i][n - 1 - i]

        return diagSum + antiDiagSum


def main() -> None:
    sol = Solution1572()
    mat1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    mat2 = [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]
    mat3 = [[5]]
    print(sol.diagonalSum(mat1))  # 25
    print(sol.diagonalSum(mat2))  # 8
    print(sol.diagonalSum(mat3))  # 5


if __name__ == "__main__":
    main()
