# https://leetcode.com/problems/set-matrix-zeroes/

from typing import List


class Solution73:

    # T: O(m*n), S: (m+n)
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rows = len(matrix)
        cols = len(matrix[0])
        rowsToSet = [False] * rows
        colsToSet = [False] * cols
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 0:
                    rowsToSet[row] = True
                    colsToSet[col] = True
        for r in range(rows):
            if rowsToSet[r]:
                self.resetRow(matrix, r)
        for c in range(cols):
            if colsToSet[c]:
                self.resetCol(matrix, c)

    # O(m*n), S: O(1)
    def setZeroesOpt(self, matrix: List[List[int]]) -> None:
        rows = len(matrix)
        cols = len(matrix[0])
        firstRowHasZero = False
        firstColHasZero = False
        for col in range(cols):
            if matrix[0][col] == 0:
                firstRowHasZero = True
                break
        for row in range(rows):
            if matrix[row][0] == 0:
                firstColHasZero = True
                break
        for row in range(1, rows):
            for col in range(1, cols):
                if matrix[row][col] == 0:
                    matrix[row][0] = 0
                    matrix[0][col] = 0
        for row in range(1, rows):
            if matrix[row][0] == 0:
                self.resetRow(matrix, row)
        for col in range(1, cols):
            if matrix[0][col] == 0:
                self.resetCol(matrix, col)
        if firstRowHasZero:
            self.resetRow(matrix, 0)
        if firstColHasZero:
            self.resetCol(matrix, 0)

    def resetRow(self, matrix: List[List[int]], rowIdx: int) -> None:
        cols = len(matrix[0])
        for c in range(cols):
            matrix[rowIdx][c] = 0

    def resetCol(self, matrix: List[List[int]], colIdx: int) -> None:
        rows = len(matrix)
        for r in range(rows):
            matrix[r][colIdx] = 0


def main() -> None:
    sol = Solution73()
    matrix1 = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    matrix2 = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]
    sol.setZeroes(matrix1)
    sol.setZeroesOpt(matrix2)
    print(matrix1)  # [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
    print(matrix2)  # [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]


if __name__ == "__main__":
    main()
