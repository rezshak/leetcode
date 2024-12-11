// https://leetcode.com/problems/validate-binary-search-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(h)
func isValidBST(root *TreeNode) bool {
	return validate(root, nil, nil)
}

func validate(node *TreeNode, lower, upper *int) bool {
	if node == nil {
		return true
	}

	if lower != nil && node.Val <= *lower {
		return false
	}
	if upper != nil && node.Val >= *upper {
		return false
	}

	return validate(node.Right, &node.Val, upper) && validate(node.Left, lower, &node.Val)
}

func main() {
	root1 := &TreeNode{Val: 2, Left: &TreeNode{Val: 1}, Right: &TreeNode{Val: 3}}
	fmt.Println(isValidBST(root1)) // true

	root2 := &TreeNode{Val: 5}
	root2.Left = &TreeNode{Val: 1}
	root2.Right = &TreeNode{Val: 4, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 6}}
	fmt.Println(isValidBST(root2)) // false
}
