// https://leetcode.com/problems/intersection-of-two-arrays-ii/

package main

import "fmt"

// T: O(n+m), S: O(min(n+m))
func intersect(nums1 []int, nums2 []int) []int {
	if len(nums1) > len(nums2) {
		return intersect(nums2, nums1)
	}
	freqMap := getFreqCount(nums1)
	k := 0
	for _, n := range nums2 {
		if count, found := freqMap[n]; found {
			if count > 0 {
				nums2[k] = n
				k++
				freqMap[n]--
			}
		}
	}
	return nums2[0:k]
}

func getFreqCount(nums []int) map[int]int {
	freqMap := make(map[int]int)
	for _, n := range nums {
		freqMap[n]++
	}
	return freqMap
}

func main() {
	nums1 := []int{1, 2, 2, 1}
	nums2 := []int{2, 2}
	fmt.Println(intersect(nums1, nums2)) // [2 2]
	nums1 = []int{4, 9, 5}
	nums2 = []int{9, 4, 9, 8, 4}
	fmt.Println(intersect(nums1, nums2)) // [4,9]
}
