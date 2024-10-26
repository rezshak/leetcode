# https://leetcode.com/problems/robot-return-to-origin/

class Solution657:

    # T: O(n), S: O(1)
    def judgeCircle(self, moves: str) -> bool:
        board = [0] * 2  # x, y
        for mv in moves:
            if mv == 'U':
                board[1] += 1
            elif mv == 'D':
                board[1] -= 1
            elif mv == 'L':
                board[0] -= 1
            elif mv == 'R':
                board[0] += 1

        return board[0] == 0 and board[1] == 0


def main() -> None:
    sol = Solution657()
    moves1 = "UD"
    moves2 = "LL"
    moves3 = "UDLR"
    moves4 = "UUDDLLRR"
    print(sol.judgeCircle(moves1))  # True
    print(sol.judgeCircle(moves2))  # False
    print(sol.judgeCircle(moves3))  # True
    print(sol.judgeCircle(moves4))  # True


if __name__ == "__main__":
    main()
