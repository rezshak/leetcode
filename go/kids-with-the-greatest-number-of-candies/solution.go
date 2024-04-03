// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(n)
func kidsWithCandies(candies []int, extraCandies int) []bool {
	max := math.MinInt32
	for _, n := range candies {
		if n > max {
			max = n
		}
	}
	var res = make([]bool, len(candies))
	for i, n := range candies {
		res[i] = n+extraCandies >= max
	}
	return res
}

func main() {
	c1 := []int{2, 3, 5, 1, 3}
	c2 := []int{4, 2, 1, 1, 2}
	c3 := []int{12, 1, 12}
	fmt.Println(kidsWithCandies(c1, 3))  // [true,true,true,false,true]
	fmt.Println(kidsWithCandies(c2, 1))  // [true,false,false,false,false]
	fmt.Println(kidsWithCandies(c3, 10)) // [true,false,true]
}
