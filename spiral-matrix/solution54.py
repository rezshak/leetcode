# https://leetcode.com/problems/spiral-matrix/

from typing import List


class Solution54:

    # T: O(m*n), S: O(1)
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows, cols = len(matrix), len(matrix[0])
        top, bottom = 0, rows - 1
        left, right = 0, cols - 1
        result = []

        while left <= right and top <= bottom:
            # Traverse left -> right
            for col in range(left, right + 1):
                result.append(matrix[top][col])
            top += 1
            # Traverse top -> bottom
            for row in range(top, bottom + 1):
                result.append(matrix[row][right])
            right -= 1
            if top <= bottom:
                # Traverse right -> left
                for col in range(right, left - 1, -1):
                    result.append(matrix[bottom][col])
                bottom -= 1
            if left <= right:
                # Traverse bottom -> top
                for row in range(bottom, top - 1, -1):
                    result.append(matrix[row][left])
                left += 1

        return result


def main() -> None:
    sol = Solution54()
    matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    matrix2 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    matrix3 = [[1, 2, 3, 4]]
    print(sol.spiralOrder(matrix1))  # [1, 2, 3, 6, 9, 8, 7, 4, 5]
    print(sol.spiralOrder(matrix2))  # [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    print(sol.spiralOrder(matrix3))  # [1, 2, 3, 4]


if __name__ == "__main__":
    main()
