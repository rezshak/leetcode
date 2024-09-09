// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

package main

import "fmt"

// T: O(1), S: O(1)
func countOdds(low int, high int) int {
	if (low & 1) == 0 {
		low++
	}
	if low > high {
		return 0
	}
	return (high-low)/2 + 1
}

// T: O(h-l), S: O(1)
func countOddsBrute(low int, high int) int {
	count := 0
	for low <= high {
		if (low & 1) == 1 {
			count++
		}
		low++
	}
	return count
}

func main() {
	fmt.Println(countOdds(3, 7))       // 3
	fmt.Println(countOddsBrute(3, 7))  // 3
	fmt.Println(countOdds(8, 10))      // 1
	fmt.Println(countOddsBrute(8, 10)) // 1
}
