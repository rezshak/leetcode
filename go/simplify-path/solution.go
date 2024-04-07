// https://leetcode.com/problems/simplify-path/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func simplifyPath(path string) string {
	stack := make([]string, 0)
	for _, p := range strings.Split(path, "/") {
		if p == ".." {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		} else if p != "" && p != "." {
			stack = append(stack, p)
		}
	}
	return "/" + strings.Join(stack, "/")
}

func main() {
	path1 := "/home/"
	fmt.Println(simplifyPath(path1)) // "/home"
	path2 := "/../"
	fmt.Println(simplifyPath(path2)) // "/"
	path3 := "/home//foo/"
	fmt.Println(simplifyPath(path3)) // "/home/foo"
}
