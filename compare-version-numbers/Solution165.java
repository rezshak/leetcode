// https://leetcode.com/problems/compare-version-numbers/

class Solution165 {

    // T: O(max(n,m)), S: O(n+m)
    public int compareVersion(String version1, String version2) {
        // Split versions into arrays of integers
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        // Get the length of longer version number
        int maxLength = Math.max(v1Parts.length, v2Parts.length);

        // Compare each revision number
        for (int i = 0; i < maxLength; i++) {
            // Get current revision number, use 0 if index exceeds array length
            int v1Val = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int v2Val = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            // Compare current revision numbers
            if (v1Val > v2Val) {
                return 1;
            } else if (v1Val < v2Val) {
                return -1;
            }
        }

        // All revision numbers are equal
        return 0;
    }

    public static void main(String[] args) {
        var sol = new Solution165();
        var v1 = "1.2";
        var v2 = "1.10";
        System.out.println(sol.compareVersion(v1, v2)); // -1
        v1 = "1.01";
        v2 = "1.001";
        System.out.println(sol.compareVersion(v1, v2)); // 0
        v1 = "1.0";
        v2 = "1.0.0.0";
        System.out.println(sol.compareVersion(v1, v2)); // 0
    }

}
