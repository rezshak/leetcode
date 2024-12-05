// https://leetcode.com/problems/combination-sum/

package main

import (
	"fmt"
	"sort"
)

// T: O(2^t), S: O(t)
func combinationSum(candidates []int, target int) [][]int {
	var result [][]int
	sort.Ints(candidates)
	backtrack(candidates, target, 0, 0, []int{}, &result)
	return result
}

// T: O(2^t), S: O(t)
func backtrack(candidates []int, target, total, start int, curr []int, result *[][]int) {
	if total == target {
		combination := make([]int, len(curr))
		copy(combination, curr)
		*result = append(*result, combination)
		return
	}

	for i := start; i < len(candidates); i++ {
		if total+candidates[i] > target {
			break
		}
		curr = append(curr, candidates[i])
		backtrack(candidates, target, total+candidates[i], i, curr, result)
		curr = curr[:len(curr)-1]
	}
}

func main() {
	candidates1 := []int{2, 3, 6, 7}
	target1 := 7
	result1 := combinationSum(candidates1, target1)
	fmt.Println(result1) // [[2, 2, 3], [7]]

	candidates2 := []int{2, 3, 5}
	target2 := 8
	result2 := combinationSum(candidates2, target2)
	fmt.Println(result2) // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

	candidates3 := []int{2}
	target3 := 3
	result3 := combinationSum(candidates3, target3)
	fmt.Println(result3) // []
}
