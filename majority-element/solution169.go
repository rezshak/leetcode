// https://leetcode.com/problems/majority-element/

package main

import (
	"fmt"
	"sort"
)

// T: O(n), S: O(1)
func majorityElement(nums []int) int {
	sort.Ints(nums)
	return nums[len(nums)/2]
}

// T: O(n), S: O(n)
func majorityElementMap(nums []int) int {
	counts := make(map[int]int)
	for _, num := range nums {
		counts[num]++
		if counts[num] > len(nums)/2 {
			return num
		}
	}
	return -1
}

// T: O(n), S: O(1)
func majorityElementBoyerMoore(nums []int) int {
	count := 0
	candidate := 0

	for _, num := range nums {
		if count == 0 {
			candidate = num
		}
		if num == candidate {
			count++
		} else {
			count--
		}
	}

	return candidate
}

func main() {
	nums1 := []int{3, 2, 3}
	nums2 := []int{2, 2, 1, 1, 1, 2, 2}
	fmt.Println(majorityElement(nums1))           // 3
	fmt.Println(majorityElement(nums2))           // 2
	fmt.Println(majorityElementMap(nums1))        // 3
	fmt.Println(majorityElementMap(nums2))        // 2
	fmt.Println(majorityElementBoyerMoore(nums1)) // 3
	fmt.Println(majorityElementBoyerMoore(nums2)) // 2
}
