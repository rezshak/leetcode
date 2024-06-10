// https://leetcode.com/problems/find-the-duplicate-number/

package main

import "fmt"

// T: O(n), S: O(n)
func findDuplicate(nums []int) int {
	set := make(map[int]bool)
	for _, n := range nums {
		if _, exists := set[n]; exists {
			return n
		}
		set[n] = true
	}
	return -1
}

// T: O(n), S: O(1)
func findDuplicateFloyd(nums []int) int {
	slow, fast := 0, 0
	for {
		slow = nums[slow]
		fast = nums[nums[fast]]
		if slow == fast {
			break
		}
	}
	slow = 0
	for slow != fast {
		slow = nums[slow]
		fast = nums[fast]
	}
	return slow
}

func main() {
	nums1 := []int{1, 3, 4, 2, 2}
	nums2 := []int{3, 1, 3, 4, 2}
	nums3 := []int{3, 3, 3, 3, 3}
	fmt.Println(findDuplicate(nums1))      // 2
	fmt.Println(findDuplicate(nums2))      // 3
	fmt.Println(findDuplicateFloyd(nums3)) // 3
	fmt.Println(findDuplicateFloyd(nums1)) // 2
	fmt.Println(findDuplicateFloyd(nums2)) // 3
	fmt.Println(findDuplicateFloyd(nums3)) // 3
}
