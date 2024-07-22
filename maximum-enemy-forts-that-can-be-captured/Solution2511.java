// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/

class Solution2511 {

    // T: O(n), S: O(1)
    public int captureForts(int[] forts) {
        int ans = 0;
        for (int r = 0, l = 0; r < forts.length; r++)
            if (forts[r] != 0) {
                if (forts[l] == -forts[r]) {
                    ans = Math.max(ans, r - l - 1);
                }
                l = r;
            }
        return ans;
    }

    public static void main(String[] args) {
        var sol = new Solution2511();
        var forts1 = new int[] { 1, 0, 0, -1, 0, 0, 0, 0, 1 };
        var forts2 = new int[] { 0, 0, 1, -1 };
        System.out.println(sol.captureForts(forts1)); // 4
        System.out.println(sol.captureForts(forts2)); // 0
    }

}
