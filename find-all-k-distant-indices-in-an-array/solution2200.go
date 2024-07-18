package main

import (
	"fmt"
	"sort"
)

// T: O(n), S: O(n)
func findKDistantIndices(nums []int, key int, k int) []int {
	n := len(nums)
	indices := make(map[int]bool)
	for i, num := range nums {
		if num == key {
			from := max(i-k, 0)
			till := min(i+k, n-1)
			for j := from; j <= till; j++ {
				indices[j] = true
			}
		}
	}
	result := make([]int, 0, len(indices))
	for k := range indices {
		result = append(result, k)
	}
	sort.Ints(result)
	return result
}

func main() {
	var nums1 = []int{3, 4, 9, 1, 3, 9, 5}
	var nums2 = []int{2, 2, 2, 2, 2}
	var nums3 = []int{}
	var nums4 = []int{1, 2, 3, 4, 5}
	fmt.Println(findKDistantIndices(nums1, 9, 1)) // [1,2,3,4,5,6]
	fmt.Println(findKDistantIndices(nums2, 2, 2)) // [0,1,2,3,4]
	fmt.Println(findKDistantIndices(nums3, 1, 1)) // []
	fmt.Println(findKDistantIndices(nums4, 6, 1)) // []
}
