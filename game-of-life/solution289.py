# https://leetcode.com/problems/game-of-life/

import copy
from typing import List


class Solution289:

    # T: O(mn), S: O(mn)
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows, cols = len(board), len(board[0])
        new_board = copy.deepcopy(board)

        for row in range(rows):
            for col in range(cols):
                top = max(0, row - 1)
                bottom = min(rows - 1, row + 1)
                left = max(0, col - 1)
                right = min(cols - 1, col + 1)
                live_neighbors = 0

                for r in range(top, bottom + 1):
                    for c in range(left, right + 1):
                        if not (r == row and c == col) and new_board[r][c] == 1:
                            live_neighbors += 1

                if live_neighbors < 2 or live_neighbors > 3:
                    board[row][col] = 0
                elif live_neighbors == 3:
                    board[row][col] = 1

    # T: O(mn), S: O(1)
    def gameOfLifeOpt(self, board: List[List[int]]) -> None:
        rows, cols = len(board), len(board[0])
        for row in range(rows):
            for col in range(cols):
                live_neighbors = 0
                top = max(0, row - 1)
                bottom = min(rows - 1, row + 1)
                left = max(0, col - 1)
                right = min(cols - 1, col + 1)
                for r in range(top, bottom + 1):
                    for c in range(left, right + 1):
                        if not (r == row and c == col) and abs(board[r][c]) == 1:
                            live_neighbors += 1
                if board[row][col] == 1:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[row][col] = -1  # Alive to dead
                else:
                    if live_neighbors == 3:
                        board[row][col] = 2  # Dead to alive
        # Second pass: convert the transitional states to final states
        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0


def main() -> None:
    sol = Solution289()

    board1 = [
        [0, 1, 0],
        [0, 0, 1],
        [1, 1, 1],
        [0, 0, 0]
    ]
    sol.gameOfLife(board1)
    print(board1)

    board2 = [
        [1, 1],
        [1, 0]
    ]
    sol.gameOfLife(board2)
    print(board2)

    board3 = [
        [0, 1, 0],
        [0, 0, 1],
        [1, 1, 1],
        [0, 0, 0]
    ]
    sol.gameOfLifeOpt(board3)
    print(board3)

    board4 = [
        [1, 1],
        [1, 0]
    ]
    sol.gameOfLifeOpt(board4)
    print(board4)


if __name__ == "__main__":
    main()
