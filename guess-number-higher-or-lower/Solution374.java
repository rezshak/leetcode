// https://leetcode.com/problems/guess-number-higher-or-lower/

class GuessGame {
    int guess(int num) {
        if (num > 6)
            return -1;
        if (num < 6)
            return 1;
        return 0;
    }
}

class Solution374 extends GuessGame {

    // T: O(log n), S: O(1)
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == -1) {
                high = mid - 1;
            } else if (res == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new Solution374();
        System.out.println(sol.guessNumber(10)); // 6
    }

}
