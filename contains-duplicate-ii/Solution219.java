// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.HashSet;

class Solution219 {

    // T: O(n), S: O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // T: O(n), S: O(n)
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new Solution219();
        var nums1 = new int[] { 1, 2, 3, 1 };
        var nums2 = new int[] { 1, 0, 1, 1 };
        var nums3 = new int[] { 1, 2, 3, 1, 2, 3 };
        System.out.println(sol.containsNearbyDuplicate(nums1, 3)); // true
        System.out.println(sol.containsNearbyDuplicate(nums2, 1)); // true
        System.out.println(sol.containsNearbyDuplicate(nums3, 2)); // false
        System.out.println(sol.containsNearbyDuplicate2(nums1, 3)); // true
        System.out.println(sol.containsNearbyDuplicate2(nums2, 1)); // true
        System.out.println(sol.containsNearbyDuplicate2(nums3, 2)); // false
    }

}
