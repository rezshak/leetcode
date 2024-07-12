// https://leetcode.com/problems/two-sum-iii-data-structure-design/

package main

import (
	"fmt"
	"sort"
)

type TwoSum struct {
	nums   []int
	sorted bool
}

func Constructor() TwoSum {
	return TwoSum{
		nums:   make([]int, 0),
		sorted: false,
	}
}

// T: O(1), S: O(n)
func (ts *TwoSum) Add(number int) {
	ts.nums = append(ts.nums, number)
	ts.sorted = false
}

// T: O(n log n), S: O(n)
func (ts *TwoSum) Find(value int) bool {
	if !ts.sorted {
		sort.Ints(ts.nums)
		ts.sorted = true
	}
	left, right := 0, len(ts.nums)-1
	for left < right {
		n1, n2 := ts.nums[left], ts.nums[right]
		sum := n1 + n2
		if sum < value {
			left++
		} else if sum > value {
			right--
		} else {
			return true
		}
	}
	return false
}

func main() {
	obj := Constructor()
	obj.Add(1)
	obj.Add(3)
	obj.Add(5)
	fmt.Println(obj.Find(4)) // true
	fmt.Println(obj.Find(7)) // false
}
