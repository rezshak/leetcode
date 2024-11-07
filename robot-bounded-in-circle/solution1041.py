# https://leetcode.com/problems/robot-bounded-in-circle/

from enum import Enum


class Dir(Enum):
    North = 1
    South = 2
    East = 3
    West = 4


class Solution1041:

    # T: O(n), S: O(1)
    def isRobotBounded(self, instructions: str) -> bool:
        x, y = 0, 0
        dir = Dir.North
        for d in instructions:
            if d == 'G':
                if dir == Dir.North:
                    y += 1
                elif dir == Dir.South:
                    y -= 1
                elif dir == Dir.East:
                    x += 1
                elif dir == Dir.West:
                    x -= 1
            elif d == 'L':
                if dir == Dir.North:
                    dir = Dir.West
                elif dir == Dir.South:
                    dir = Dir.East
                elif dir == Dir.East:
                    dir = Dir.North
                elif dir == Dir.West:
                    dir = Dir.South
            elif d == 'R':
                if dir == Dir.North:
                    dir = Dir.East
                elif dir == Dir.South:
                    dir = Dir.West
                elif dir == Dir.East:
                    dir = Dir.South
                elif dir == Dir.West:
                    dir = Dir.North

        return (x == 0 and y == 0) or dir != Dir.North


def main() -> None:
    sol = Solution1041()
    instructions1 = "GGLLGG"
    instructions2 = "GG"
    instructions3 = "GL"
    print(sol.isRobotBounded(instructions1))  # True
    print(sol.isRobotBounded(instructions2))  # False
    print(sol.isRobotBounded(instructions3))  # True


if __name__ == "__main__":
    main()
