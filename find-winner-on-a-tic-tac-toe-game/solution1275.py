# https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

N = 3


class Solution1275:

    # T: O(m), S: O(1)
    def tictactoe(self, moves: list[list[int]]) -> str:
        n = len(moves)
        # Row, column, and diagonal sums
        rows = [0] * N
        cols = [0] * N
        diag = 0
        anti_diag = 0
        player = 1
        for move in moves:
            row = move[0]
            col = move[1]
            rows[row] += player
            cols[col] += player
            if row == col:
                diag += player
            if row + col == N - 1:
                anti_diag += player
            if abs(rows[row]) == N or abs(cols[col]) == N or abs(diag) == N or abs(anti_diag) == N:
                return "A" if player == 1 else "B"
            player *= -1
        return "Draw" if n == N * N else "Pending"


if __name__ == "__main__":
    sol = Solution1275()
    moves1 = [[0, 0], [2, 0], [1, 1], [2, 1], [2, 2]]
    moves2 = [[0, 0], [1, 1], [0, 1], [0, 2], [1, 0], [2, 0]]
    print(sol.tictactoe(moves1))  # A
    print(sol.tictactoe(moves2))  # B
