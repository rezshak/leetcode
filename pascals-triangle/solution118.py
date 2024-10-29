# // https://leetcode.com/problems/pascals-triangle/


from typing import List


class Solution118:

    # T: O(n^2), S: O(n^2)
    def generate(self, numRows: int) -> List[List[int]]:
        triangle = []
        if numRows == 0:
            return triangle
        triangle.append([1])
        for r in range(1, numRows):
            newRow = [1]
            prevRow = triangle[r - 1]
            for c in range(1, len(prevRow)):
                num = prevRow[c - 1] + prevRow[c]
                newRow.append(num)
            newRow.append(1)
            triangle.append(newRow)
        return triangle


def main() -> None:
    sol = Solution118()
    # [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    print(sol.generate(5))
    # [[1]]
    print(sol.generate(1))


if __name__ == "__main__":
    main()
