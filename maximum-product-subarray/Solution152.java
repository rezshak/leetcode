// https://leetcode.com/problems/maximum-product-subarray/

class Solution152 {

    // T: O(n), S: O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int maxProduct = nums[0];
        int currentProduct = 1;

        // Forward pass
        for (int i = 0; i < n; i++) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);

            // Reset if product becomes zero
            if (currentProduct == 0) {
                currentProduct = 1;
            }
        }

        // Backward pass
        currentProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);

            // Reset if product becomes zero
            if (currentProduct == 0) {
                currentProduct = 1;
            }
        }

        return maxProduct;
    }

    // T: O(n), S: O(1)
    public int maxProductKadane(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            int tempMin = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    // T: O(n^2), S: O(1)
    public int maxProductBrute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int result = nums[0];
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            result = Math.max(result, cur);
            for (int j = i + 1; j < n; j++) {
                cur *= nums[j];
                result = Math.max(result, cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution152();
        var nums1 = new int[] { 2, 3, -2, 4 };
        var nums2 = new int[] { -2, 0, -1 };
        System.out.println(sol.maxProduct(nums1)); // 6
        System.out.println(sol.maxProductKadane(nums1)); // 6
        System.out.println(sol.maxProductBrute(nums1)); // 6
        System.out.println(sol.maxProduct(nums2)); // 0
        System.out.println(sol.maxProductKadane(nums2)); // 0
        System.out.println(sol.maxProductBrute(nums2)); // 0
    }

}
