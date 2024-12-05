// https://leetcode.com/problems/sum-of-two-integers/

package main

import "fmt"

// T: O(1), S: O(1)
func getSum(a int, b int) int {
	for b != 0 {
		carry := a & b
		a = a ^ b
		b = carry << 1
	}
	return a
}

func main() {
	fmt.Println(getSum(1, 2)) // 3
	fmt.Println(getSum(2, 3)) // 5
}
