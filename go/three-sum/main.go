// https://leetcode.com/problems/3sum/

package main

import (
	"fmt"
	"sort"
)

// T: O(n^2), S: O(n)
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	result := [][]int{}
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		low, high := i+1, len(nums)-1
		for low < high {
			sum := nums[i] + nums[low] + nums[high]
			if sum == 0 {
				result = append(result, []int{nums[i], nums[low], nums[high]})
				for low < high && nums[low] == nums[low+1] {
					low++
				}
				for low < high && nums[high] == nums[high-1] {
					high--
				}
				low++
				high--
			} else if sum < 0 {
				low++
			} else {
				high--
			}
		}
	}
	return result
}

func main() {
	nums1 := []int{-1, 0, 1, 2, -1, -4}
	nums2 := []int{0, 1, 1}
	nums3 := []int{0, 0, 0}
	fmt.Println(threeSum(nums1))
	fmt.Println(threeSum(nums2))
	fmt.Println(threeSum(nums3))
}
