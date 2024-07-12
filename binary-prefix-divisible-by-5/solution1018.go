// https://leetcode.com/problems/binary-prefix-divisible-by-5/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func prefixesDivBy5(nums []int) []bool {
	result := make([]bool, len(nums))
	dec := 0
	for i, bit := range nums {
		dec = (dec*2 + bit) % 5
		result[i] = dec == 0
	}
	return result
}

// T: O(n), S: O(n)
func prefixesDivBy5Bitwise(nums []int) []bool {
	result := make([]bool, len(nums))
	dec := 0
	for i, bit := range nums {
		dec = ((dec << 1) + bit) % 5
		result[i] = dec == 0
	}
	return result
}

func main() {
	nums1 := []int{0, 1, 1}
	nums2 := []int{1, 1, 1}
	fmt.Println(prefixesDivBy5(nums1))        // [true,false,false]
	fmt.Println(prefixesDivBy5(nums1))        // [true,false,false]
	fmt.Println(prefixesDivBy5Bitwise(nums1)) // [true,false,false]
	fmt.Println(prefixesDivBy5Bitwise(nums2)) // [false,false,false]
}
