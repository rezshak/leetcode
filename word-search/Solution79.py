# https://leetcode.com/problems/word-search/

from typing import List


class Solution79:

    # T: O(n4^L), S: O(L)
    def exist(self, board: List[List[str]], word: str) -> bool:

        def backtrack(board, word, i, j, idx):
            if idx == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[idx]:
                return False
            temp = board[i][j]
            board[i][j] = '#'
            found = (backtrack(board, word, i + 1, j, idx + 1) or
                     backtrack(board, word, i - 1, j, idx + 1) or
                     backtrack(board, word, i, j + 1, idx + 1) or
                     backtrack(board, word, i, j - 1, idx + 1))
            board[i][j] = temp
            return found

        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtrack(board, word, i, j, 0):
                    return True
        return False


def main() -> None:
    sol = Solution79()

    board1 = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word1 = "ABCCED"
    print(sol.exist(board1, word1))  # true

    board2 = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word2 = "SEE"
    print(sol.exist(board2, word2))  # true

    board3 = [
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ]
    word3 = "ABCB"
    print(sol.exist(board3, word3))  # false


if __name__ == "__main__":
    main()
