// https://leetcode.com/problems/majority-element/

package main

import "fmt"

// T: O(n), S: O(n)
func majorityElement(nums []int) int {
	freqs := make(map[int]int)
	for _, num := range nums {
		freqs[num]++
		if freqs[num] > len(nums)/2 {
			return num
		}
	}
	return -1
}

// T: O(n), S: O(1)
func majorityElement2(nums []int) int {
	majority := nums[0]
	count := 1
	for i := 1; i < len(nums); i++ {
		if count == 0 {
			majority = nums[i]
			count++
		} else if majority == nums[i] {
			count++
		} else {
			count--
		}
	}
	return majority
}

func main() {
	nums1 := []int{3, 2, 3}
	nums2 := []int{2, 2, 1, 1, 1, 2, 2}
	fmt.Println(majorityElement(nums1))  // 3
	fmt.Println(majorityElement(nums2))  // 2
	fmt.Println(majorityElement2(nums1)) // 3
	fmt.Println(majorityElement2(nums2)) // 2
}
