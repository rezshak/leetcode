# https://leetcode.com/problems/rotate-image/

from typing import List


class Solution48:

    # T: O(n), S: O(1)
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        # Transpose the matrix
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

        # print("Transposed:")
        # self.print_matrix(matrix)

        # Reverse each row
        for i in range(n):
            for j in range(n // 2):
                matrix[i][j], matrix[i][n - 1 -
                                        j] = matrix[i][n - 1 - j], matrix[i][j]

    # T: O(n^2), S: O(1)
    def rotateBrute(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        orig = [row[:] for row in matrix]
        for r in range(n):
            nums = orig[r]
            self.copy_row_to_col(matrix, nums, n - r - 1)

    def copy_row_to_col(self, matrix: List[List[int]], nums: List[int], col):
        n = len(matrix)
        for i in range(n):
            matrix[i][col] = nums[i]

    def print_matrix(self, matrix: List[List[int]]) -> None:
        for row in matrix:
            print(" ".join(map(str, row)))


def main():
    sol = Solution48()

    matrix1 = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    print("Original:")
    sol.print_matrix(matrix1)
    sol.rotate(matrix1)
    print("Rotated:")
    sol.print_matrix(matrix1)

    matrix2 = [
        [5, 1, 9, 11],
        [2, 4, 8, 10],
        [13, 3, 6, 7],
        [15, 14, 12, 16]
    ]
    print("Original:")
    sol.print_matrix(matrix2)
    sol.rotate(matrix2)
    print("Rotated:")
    sol.print_matrix(matrix2)

    matrix3 = [
        [1, 2],
        [3, 4],
    ]
    print("Original:")
    sol.print_matrix(matrix3)
    sol.rotate(matrix3)
    print("Rotated:")
    sol.print_matrix(matrix3)


if __name__ == "__main__":
    main()
