// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution1422 {

    // T: O(n), S: O(1)
    public int maxScore(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ans, zeros + ones);
        }
        return ans;
    }

    // T: O(n), S: O(n)
    public int maxScore2(String s) {
        int n = s.length();
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int zCount = 0;
        int oCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zCount++;
                zeros[i] = zCount;
            }
            if (s.charAt(n - i - 1) == '1') {
                oCount++;
                ones[n - i - 1] = oCount;
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, zeros[i] + ones[i + 1]);
        }
        return max;
    }

    // T: O(n^2), S: O(1)
    public int maxScoreBrute(String s) {
        int ans = 0, n = s.length();
        for (int i = 1; i < n; i++) {
            int leftScore = score(s, 0, i, '0');
            int rightScore = score(s, i, n, '1');
            ans = Math.max(ans, leftScore + rightScore);
        }
        return ans;
    }

    // T: O(n), S: O(1)
    private int score(String s, int start, int end, char v) {
        int score = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == v) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        var sol = new Solution1422();
        System.out.println(sol.maxScore("011101")); // 5
        System.out.println(sol.maxScore("00111")); // 5
        System.out.println(sol.maxScore("1111")); // 3
        System.out.println(sol.maxScore("00")); // 1
    }

}
