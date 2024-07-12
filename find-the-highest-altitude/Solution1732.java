// https://leetcode.com/problems/find-the-highest-altitude/

class Solution1732 {

    // T: O(n), S: O(1)
    public int largestAltitude(int[] gain) {
        int max = 0, curr = 0;
        for (int val : gain) {
            curr += val;
            if (curr > max) {
                max = curr;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new Solution1732();
        var nums1 = new int[] { -5, 1, 5, 0, -7 };
        var nums2 = new int[] { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(sol.largestAltitude(nums1)); // 1
        System.out.println(sol.largestAltitude(nums2)); // 0
    }

}
