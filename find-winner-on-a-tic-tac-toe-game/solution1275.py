# https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

N = 3  # NxN board
PLAYER1 = 1
PLAYER2 = -1


class Solution1275:

    # T: O(m), S: O(1)
    def tictactoe(self, moves: list[list[int]]) -> str:
        board = [[0] * N for _ in range(N)]
        player1_turn = True
        for move in moves:
            x, y = move
            if player1_turn:
                board[x][y] = PLAYER1
                player1_turn = False
            else:
                board[x][y] = PLAYER2
                player1_turn = True
        # Check if a row is winner
        for r in range(N):
            row_sum = sum(board[r])
            if row_sum == N:
                return "A"
            elif row_sum == -N:
                return "B"
        # Check if a col is winner
        for c in range(N):
            col_sum = sum(board[r][c] for r in range(N))
            if col_sum == N:
                return "A"
            elif col_sum == -N:
                return "B"
        # Check left-right and right-left diagonals
        lr_diag_sum = sum(board[i][i] for i in range(N))
        rl_diag_sum = sum(board[i][N - i - 1] for i in range(N))
        if lr_diag_sum == N or rl_diag_sum == N:
            return "A"
        elif lr_diag_sum == -N or rl_diag_sum == -N:
            return "B"
        if len(moves) < N * N:
            return "Pending"
        return "Draw"


def main() -> None:
    sol = Solution1275()
    moves1 = [[0, 0], [2, 0], [1, 1], [2, 1], [2, 2]]
    moves2 = [[0, 0], [1, 1], [0, 1], [0, 2], [1, 0], [2, 0]]
    print(sol.tictactoe(moves1))  # A
    print(sol.tictactoe(moves2))  # B


if __name__ == "__main__":
    main()
