// https://leetcode.com/problems/can-place-flowers/

package main

import "fmt"

// T: O(n), S: O(1)
func canPlaceFlowers(flowerbed []int, n int) bool {
	len, count := len(flowerbed), 0
	for i, val := range flowerbed {
		if val == 0 {
			leftEmpty := i == 0 || flowerbed[i-1] == 0
			rightEmpty := i == len-1 || flowerbed[i+1] == 0
			if leftEmpty && rightEmpty {
				flowerbed[i] = 1
				count++
			}
			if count >= n {
				return true
			}
		}
	}
	return false
}

func main() {
	bed1 := []int{1, 0, 0, 0, 1}
	bed2 := []int{1, 0, 0, 0, 1}
	fmt.Println(canPlaceFlowers(bed1, 1)) // true
	fmt.Println(canPlaceFlowers(bed2, 2)) // false
}
