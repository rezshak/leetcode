// https://leetcode.com/problems/contains-duplicate-ii/

package main

import "fmt"

// T: O(n), S: O(k)
func containsNearbyDuplicate(nums []int, k int) bool {
	set := make(map[int]bool)
	for i, n := range nums {
		if set[n] {
			return true
		}
		set[n] = true
		if len(set) > k {
			set[nums[i-k]] = false
		}
	}
	return false
}

// T: O(n), S: O(n)
func containsNearbyDuplicate2(nums []int, k int) bool {
	seen := make(map[int]int)
	for i, num := range nums {
		if j, ok := seen[num]; ok && i-j <= k {
			return true
		}
		seen[num] = i
	}
	return false
}

func main() {
	nums1 := []int{1, 2, 3, 1}
	nums2 := []int{1, 0, 1, 1}
	nums3 := []int{1, 2, 3, 1, 2, 3}
	fmt.Println(containsNearbyDuplicate(nums1, 3))  // true
	fmt.Println(containsNearbyDuplicate(nums2, 1))  // true
	fmt.Println(containsNearbyDuplicate(nums3, 2))  // false
	fmt.Println(containsNearbyDuplicate2(nums1, 3)) // true
	fmt.Println(containsNearbyDuplicate2(nums2, 1)) // true
	fmt.Println(containsNearbyDuplicate2(nums3, 2)) // false
}
