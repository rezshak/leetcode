// https://leetcode.com/problems/remove-element/

package main

import "fmt"

// T: O(n), S: O(1)
func removeElement(nums []int, val int) int {
	k := 0
	for _, n := range nums {
		if n != val {
			nums[k] = n
			k++
		}
	}
	return k
}

func main() {
	nums1 := []int{3, 2, 2, 3}
	nums2 := []int{0, 1, 2, 2, 3, 0, 4, 2}
	fmt.Println(removeElement(nums1, 3)) // 2
	fmt.Println(removeElement(nums2, 2)) // 5
}
