// https://leetcode.com/problems/two-sum-iii-data-structure-design/

import java.util.*;

class TwoSum170 {

    private List<Integer> nums;
    private boolean sorted;

    public TwoSum170() {
        nums = new ArrayList<>();
        sorted = false;
    }

    // T: O(1), S: O(n)
    public void add(int number) {
        nums.add(number);
        sorted = false;
    }

    // T: O(n log n), S: O(n)
    public boolean find(int value) {
        if (!sorted) {
            Collections.sort(nums);
            sorted = true;
        }
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int n1 = nums.get(left);
            int n2 = nums.get(right);
            int sum = n1 + n2;
            if (sum < value) {
                left++;
            } else if (sum > value) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var ts = new TwoSum170();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        System.out.println(ts.find(4)); // true
        System.out.println(ts.find(7)); // false
    }

}
