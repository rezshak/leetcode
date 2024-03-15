// https://leetcode.com/problems/guess-number-higher-or-lower/

package main

import "fmt"

func guess(num int) int {
	if num > 6 {
		return -1
	}
	if num < 6 {
		return 1
	}
	return 0
}

// T: O(log n), S: O(1)
func guessNumber(n int) int {
	low, high := 0, n
	for low <= high {
		mid := low + (high-low)/2
		res := guess(mid)
		if res == -1 {
			high = mid - 1
		} else if res == 1 {
			low = mid + 1
		} else {
			return mid
		}
	}
	return -1
}

func main() {
	fmt.Println(guessNumber(10)) // 6
}
