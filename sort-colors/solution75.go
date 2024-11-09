// https://leetcode.com/problems/sort-colors/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func sortColors(nums []int) {
	cnt0, cnt1, cnt2 := 0, 0, 0
	for _, n := range nums {
		if n == 0 {
			cnt0++
		} else if n == 1 {
			cnt1++
		} else if n == 2 {
			cnt2++
		}
	}
	i := 0
	for cnt0 > 0 {
		nums[i] = 0
		i++
		cnt0--
	}
	for cnt1 > 0 {
		nums[i] = 1
		i++
		cnt1--
	}
	for cnt2 > 0 {
		nums[i] = 2
		i++
		cnt2--
	}
}

// T: O(n), S: O(1)
func sortColorsOnePass(nums []int) {
	p0, p1, p2 := 0, 0, len(nums)-1
	for p1 <= p2 {
		if nums[p1] == 0 {
			nums[p0], nums[p1] = nums[p1], nums[p0]
			p0++
			p1++
		} else if nums[p1] == 1 {
			p1++
		} else {
			nums[p2], nums[p1] = nums[p1], nums[p2]
			p2--
		}
	}
}

func main() {
	nums1 := []int{2, 0, 2, 1, 1, 0}
	nums2 := []int{2, 0, 1}
	nums3 := []int{0, 2, 1}
	sortColorsOnePass(nums1)
	sortColorsOnePass(nums2)
	sortColors(nums3)
	fmt.Println(nums1) // [0,0,1,1,2,2]
	fmt.Println(nums2) // [0,1,2]
	fmt.Println(nums3) // [0,1,2]
}
