// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution1041 {

    static enum Dir {
        North, South, East, West
    };

    // T: O(n), S: O(1)
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        var dir = Dir.North;
        for (char d : instructions.toCharArray()) {
            if (d == 'G') {
                if (dir == Dir.North) {
                    y++;
                } else if (dir == Dir.South) {
                    y--;
                } else if (dir == Dir.East) {
                    x++;
                } else if (dir == Dir.West) {
                    x--;
                }
            } else if (d == 'L') {
                if (dir == Dir.North) {
                    dir = Dir.West;
                } else if (dir == Dir.South) {
                    dir = Dir.East;
                } else if (dir == Dir.East) {
                    dir = Dir.North;
                } else if (dir == Dir.West) {
                    dir = Dir.South;
                }
            } else if (d == 'R') {
                if (dir == Dir.North) {
                    dir = Dir.East;
                } else if (dir == Dir.South) {
                    dir = Dir.West;
                } else if (dir == Dir.East) {
                    dir = Dir.South;
                } else if (dir == Dir.West) {
                    dir = Dir.North;
                }
            }
        }

        return (x == 0 && y == 0) || dir != Dir.North;
    }

    public static void main(String[] args) {
        var sol = new Solution1041();
        var instructions1 = "GGLLGG";
        var instructions2 = "GG";
        var instructions3 = "GL";
        System.out.println(sol.isRobotBounded(instructions1));
        System.out.println(sol.isRobotBounded(instructions2));
        System.out.println(sol.isRobotBounded(instructions3));
    }

}
