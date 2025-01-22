"use strict";
// https://leetcode.com/problems/two-sum/
// T: O(n), S: O(n)
function twoSum(nums, target) {
    const indices = new Map();
    for (let i = 0; i < nums.length; i++) {
        const diff = target - nums[i];
        if (indices.has(diff)) {
            return [indices.get(diff), i];
        }
        indices.set(nums[i], i);
    }
    return [-1, -1];
}
const nums1 = [2, 7, 11, 15];
const nums2 = [3, 2, 4];
const nums3 = [3, 3];
console.log(twoSum(nums1, 9)); // [0, 1]
console.log(twoSum(nums2, 6)); // [1, 2]
console.log(twoSum(nums3, 6)); // [0, 1]
