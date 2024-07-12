// https://leetcode.com/problems/search-insert-position/

package main

import "fmt"

// T: O(log(n)), S: O(1)
func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if target < nums[mid] {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			return mid
		}
	}
	return left
}

func main() {
	nums := []int{1, 3, 5, 6}
	fmt.Println(searchInsert(nums, 5)) // 2
	fmt.Println(searchInsert(nums, 2)) // 1
	fmt.Println(searchInsert(nums, 7)) // 4
}
