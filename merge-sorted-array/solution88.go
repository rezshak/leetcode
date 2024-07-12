// https://leetcode.com/problems/merge-sorted-array/

package main

import "fmt"

// T: O(n+m), S: O(1)
func merge(nums1 []int, m int, nums2 []int, n int) {
	idx1 := len(nums1) - 1
	p1, p2 := m-1, n-1
	for p1 >= 0 && p2 >= 0 {
		if nums1[p1] > nums2[p2] {
			nums1[idx1] = nums1[p1]
			p1--
		} else {
			nums1[idx1] = nums2[p2]
			p2--
		}
		idx1--
	}
	for p2 >= 0 {
		nums1[idx1] = nums2[p2]
		idx1--
		p2--
	}
}

func main() {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	merge(nums1, 3, nums2, 3)
	fmt.Println(nums1) // [1 2 2 3 5 6]
	nums1 = []int{1}
	nums2 = []int{}
	merge(nums1, 1, nums2, 0)
	fmt.Println(nums1) // [1]
}
