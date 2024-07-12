// https://leetcode.com/problems/sort-array-by-parity-ii/

package main

import "fmt"

// T: O(n), S: O(n)
func sortArrayByParityII(nums []int) []int {
	n := len(nums)
	j, k := 0, 1
	ans := make([]int, n)
	for _, num := range nums {
		if num&1 == 0 {
			ans[j] = num
			j += 2
		} else {
			ans[k] = num
			k += 2
		}
	}
	return ans
}

// T: O(n), S: O(1)
func sortArrayByParityIIOpt(nums []int) []int {
	n := len(nums)
	evenPtr, oddPtr := 0, 1
	for evenPtr < n && oddPtr < n {
		if nums[evenPtr]&1 == 0 {
			evenPtr += 2
		} else if nums[oddPtr]&1 == 1 {
			oddPtr += 2
		} else {
			nums[evenPtr], nums[oddPtr] = nums[oddPtr], nums[evenPtr]
		}
	}
	return nums
}

func main() {
	nums1 := []int{4, 2, 5, 7}
	nums2 := []int{2, 3}
	fmt.Println(sortArrayByParityII(nums1))    // [4, 5, 2, 7]
	fmt.Println(sortArrayByParityIIOpt(nums1)) // [4, 5, 2, 7]
	fmt.Println(sortArrayByParityII(nums2))    // [2, 3]
	fmt.Println(sortArrayByParityIIOpt(nums2)) // [2, 3]
}
