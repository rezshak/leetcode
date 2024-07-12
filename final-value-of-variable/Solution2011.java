// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

class Solution2011 {

    // T: O(n), S: O(1)
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            switch (op) {
                case "X++":
                case "++X":
                    x++;
                    break;
                case "X--":
                case "--X":
                    x--;
                    break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        var sol = new Solution2011();
        var ops1 = new String[] { "--X", "X++", "X++" };
        var ops2 = new String[] { "++X", "++X", "X++" };
        System.out.println(sol.finalValueAfterOperations(ops1)); // 1
        System.out.println(sol.finalValueAfterOperations(ops2)); // 3
    }

}
