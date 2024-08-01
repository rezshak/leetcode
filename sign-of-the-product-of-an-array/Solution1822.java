// https://leetcode.com/problems/sign-of-the-product-of-an-array/

class Solution1822 {

    // T: O(n), S: O(1)
    public int arraySign(int[] nums) {
        int prod = 1;
        for (int n : nums) {
            if (n > 0) {
                prod *= 1;
            } else if (n < 0) {
                prod *= -1;
            } else {
                return 0;
            }
        }
        return prod;
    }

    // T: O(n), S: O(1)
    public int arraySign2(int[] nums) {
        int negCount = 0;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                negCount++;
            }
        }
        return (negCount & 1) == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        var sol = new Solution1822();
        var nums1 = new int[] { -1, -2, -3, -4, 3, 2, 1 };
        var nums2 = new int[] { 1, 5, 0, 2, -3 };
        var nums3 = new int[] { -1, 1, -1, 1, -1 };
        var nums4 = new int[] { 9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24 };
        System.out.println(sol.arraySign(nums1)); // 1
        System.out.println(sol.arraySign2(nums1)); // 1
        System.out.println(sol.arraySign(nums2)); // 0
        System.out.println(sol.arraySign2(nums2)); // 0
        System.out.println(sol.arraySign(nums3)); // -1
        System.out.println(sol.arraySign2(nums3)); // -1
        System.out.println(sol.arraySign(nums4)); // -1
        System.out.println(sol.arraySign2(nums4)); // -1
    }

}
