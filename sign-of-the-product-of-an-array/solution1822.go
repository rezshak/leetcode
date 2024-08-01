// https://leetcode.com/problems/sign-of-the-product-of-an-array/

package main

import "fmt"

// T: O(n), S: O(1)
func arraySign(nums []int) int {
	prod := 1
	for _, n := range nums {
		if n > 0 {
			prod *= 1
		} else if n < 0 {
			prod *= -1
		} else {
			return 0
		}
	}
	return prod
}

// T: O(n), S: O(1)
func arraySign2(nums []int) int {
	negCount := 0
	for _, n := range nums {
		if n == 0 {
			return 0
		}
		if n < 0 {
			negCount++
		}
	}
	if negCount&1 == 0 {
		return 1
	}
	return -1
}

func main() {
	var nums1 = []int{-1, -2, -3, -4, 3, 2, 1}
	var nums2 = []int{1, 5, 0, 2, -3}
	var nums3 = []int{-1, 1, -1, 1, -1}
	var nums4 = []int{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24}
	fmt.Println(arraySign(nums1))  // 1
	fmt.Println(arraySign2(nums1)) // 1
	fmt.Println(arraySign(nums2))  // 0
	fmt.Println(arraySign2(nums2)) // 0
	fmt.Println(arraySign(nums3))  // -1
	fmt.Println(arraySign2(nums3)) // -1
	fmt.Println(arraySign(nums4))  // -1
	fmt.Println(arraySign2(nums4)) // -1
}
