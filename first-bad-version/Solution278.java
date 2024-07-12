// https://leetcode.com/problems/first-bad-version/

class VersionControl {
    boolean isBadVersion(int n) {
        return n >= 4;
    }
}

class Solution278 extends VersionControl {

    // T: O(log n), S: O(1)
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var sol = new Solution278();
        System.out.println(sol.firstBadVersion(5)); // 4
    }

}
