// https://leetcode.com/problems/long-pressed-name/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func isLongPressedName(name string, typed string) bool {
	if name == typed {
		return true
	}
	i, j := 0, 0
	for j < len(typed) {
		if i < len(name) && name[i] == typed[j] {
			i++
			j++
		} else if j > 0 && typed[j] == typed[j-1] {
			j++
		} else {
			return false
		}
	}
	return i == len(name)
}

func main() {
	n1 := "alex"
	t1 := "aaleex"
	n2 := "saeed"
	t2 := "ssaaedd"
	fmt.Println(isLongPressedName(n1, t1)) // true
	fmt.Println(isLongPressedName(n2, t2)) // false
}
